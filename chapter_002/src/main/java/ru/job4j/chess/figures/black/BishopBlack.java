package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.exceptions.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 20.09.2018
 */
 
 /**
 * Класс описывает фигуру Слон и расширяет абстрактный класс Figure.
 */
public class BishopBlack extends Figure {
    /**
     * Конструктор фигуры Слон.
     * @param position позиция, на которой создать фигуру.
     */
    public BishopBlack(final Cell position) {
        super(position);
    }

    /**
     * Метод возвращает текущую позицию фигуры на доске.
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Метод определяет путь фигуры.
     * @param source - исходная клетка на доске, в которой стоит фигура.
     * @param dest - конечная клетка доски, куда ходим.
     * @return - возвращает массив клеток - путь, который нужно пройти фигуре. Клетка source в этот массив не
	 * включается, т.к. фигура уже стоит в ней. Клетка dest - включается.
     * ImpossibleMoveException - выбросить исключение, если фигура не может так ходить.
     * Слон ходит по диагонали, поэтому следующая клетка на пути хода отличается от предыдущей
     * на deltaX и deltaY = +1 или deltaX и deltaY = -1.
     * Переменные x,y - текущие координаты клеток, через которые проходит слон.
     * Если слон вышел за границы доски - значит надо выбросить исключение ImpossibleMoveException.
     * Диапазон допустимых значений x и y от 0 до 7.
     */	
    @Override
    public Cell[] way(Cell source, Cell dest) {
        int x1 = source.x;
        int y1 = source.y;
        int x2 = dest.x;
        int y2 = dest.y;		
        int deltaX = Integer.compare(x2, x1);
        int deltaY = Integer.compare(y2, y1);	
        int moveX = Math.abs(x1 - x2);
        int moveY = Math.abs(y1 - y2);
        if (moveX != moveY || (x2 > 7 || y2 > 7) || (x2 < 0 || y2 < 0)) {
            throw new ImpossibleMoveException("Слон не может так ходить");		
        } else {
            Cell[] steps = new Cell[moveX];
            for (int i = 0; i < moveX; i++) {
                x1 += deltaX;
                y1 += deltaY;
                steps[i] = Cell.findCell(x1, y1);
            }
            return steps;
        }
    }

    /**
     * Метод создает копию фигуры для ее переноса в другую клетку на доске.
     * @param dest новые координаты фигуры.
     * @return новая фигура.
     */	
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
