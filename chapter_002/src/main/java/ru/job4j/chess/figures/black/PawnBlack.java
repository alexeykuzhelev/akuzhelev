package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 20.09.2018
 */

/**
 * Класс описывает фигуру Пешка и расширяет абстрактный класс Figure.
 */
public class PawnBlack extends Figure {
    /**
     * Конструктор фигуры Пешка.
     * @param position позиция, на которой создать фигуру.
     */
    public PawnBlack(final Cell position) {
        super(position);
    }

    /**
     * Метод возвращает текущую позицию фигуры на доске.
     */
    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[] {dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
