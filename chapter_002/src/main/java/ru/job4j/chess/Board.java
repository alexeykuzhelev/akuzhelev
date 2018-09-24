package ru.job4j.chess;

import ru.job4j.chess.figures.*;
import ru.job4j.chess.exceptions.*;

import static java.lang.Math.abs;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 20.09.2018
 */

/**
 * Класс, реализующий шахматную доску.
 */
public class Board {
    /**
     * Массив содержит фигуры, находящиеся на доске.
     */
    private Figure[] figures = new Figure[32];
    /**
     * Позиция (индекс) массива фигур - клетка, куда помещается фигура на шахматной доске.
     * Также показывает текущее количество фигур на доске.
     */
    private int position = 0;

    /**
     * Метод добавляет фигуры в массив фигур (на доску).
     * @param figure фигура, добавляемая в массив фигур.
     */
    void add(Figure figure) {
        this.figures[position++] = figure;
    }

    /**
     * Метод устанавливает правила движения фигуры на доске.
     * Проверить, что в исходной клетке source есть фигура, чтобы ею ходить.
     * Проверить, может ли фигура ходить по такому пути.
     * Проверить, что полученный путь не занят другими фигурами.
     * Если все правильно, записать в клетку новое положение фигуры Figure figure.copy(Cell dest).
     * index - индекс найденной фигуры в массиве фигур.
     * Cell[] steps - массив клеток (путь), которые должна пройти фигура.
     * @param source исходная клетка на доске, отсюда ходим.
     * @param dest конечная клетка доски, куда ходим.
     * @return true - ход выполнен, false - ход не выполнен.
     * FigureNotFoundException выбросить исключение, когда в поле source нет фигуры для хода.
     * OccupiedWayException выбросить исключение, когда на пути фигуры стоит другая фигура.
     */
    public boolean move(Cell source, Cell dest) {
        if (source.equals(dest)) {
            return false;
        } else {
            try {
                int index = this.findIndex(source);
                if (index == -1) {
                    throw new FigureNotFoundException("В исходной клетке нет фигуры");
                }
                Cell[] steps = this.figures[index].way(source, dest);
                for (Cell step : steps) {
                    for (int i = 0; i < this.position; i++) {
                        if (figures[i].occupied(step)) {
                            throw new OccupiedWayException("На пути стоит другая фигура");
                        }
                    }
                }
                figures[index] = figures[index].copy(dest);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }

    /**
     * Метод обнуляет ячейки и индекс массива фигур.	
     */
    public void clean() {
        for (int i = 0; i < this.figures.length; i++) {
            this.figures[i] = null;
        }
        this.position = 0;
    }

    /**
     * Метод ищет, есть ли на доске фигура в исходной клетке, откуда ходим.
     * Если фигура в клетке есть, то возвращается индекс найденной фигуры в массиве фигур.
     * Если фигуры в клетке нет, то возвращается -1.
     * @param cell - исходная клетка, откуда ходим.
     * @return index - индекс найденной фигуры в массиве фигур.
     */
    private int findIndex(Cell cell) {
        int index = -1;
        for (int i = 0; i < this.position; i++) {
            if (this.figures[i] != null && this.figures[i].occupied(cell)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
