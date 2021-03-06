package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 20.09.2018
 */

/**
 * Класс описывает фигуру Ладья и расширяет абстрактный класс Figure.
 */
public class RookBlack extends Figure {
    /**
     * Конструктор фигуры Ладья.
     * @param position позиция, на которой создать фигуру.
     */
    public RookBlack(final Cell position) {
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
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
