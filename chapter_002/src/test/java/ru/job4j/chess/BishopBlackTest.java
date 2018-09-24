package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.black.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static ru.job4j.chess.figures.Cell.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 23.09.2018
 */

/**
 * Класс BishopBlackTest содержит JUnit тесты для для тестирования хода фигуры Слон.
 */
public class BishopBlackTest {
    /**
     * Тест, проверяющий невозможность хода Слона, если на его пути стоит другая фигура.
     * Выбрасывается исключение OccupiedWayException, если ход невозможен.
     */
    @Test
    public void whenMoveBishopThroughPawnWhenException() {
        Board board = new Board();
        boolean result = true;
        board.add(new PawnBlack(E7));
        board.add(new BishopBlack(F8));
        if (board.move(F8, B4)) {
            result = false;
            System.out.println("Слон может ходить");
        }
        assertTrue(result);
    }

    /**
     * Тест, проверяющий неправильность хода Слона без других фигур на его пути.
     * Выбрасывается исключение ImpossibleMoveException, если Слон не может так ходить.
     */
    @Test
    public void whenMoveBishopVerticalFreeWayWhenException() {
        Board board = new Board();
        boolean result = true;
        board.add(new BishopBlack(F8));
        if (board.move(F8, F6)) {
            result = false;
            System.out.println("Слон может так ходить");
        }
        assertTrue(result);
    }

    /**
     * Тест, проверяющий правильность хода Слона без других фигур на его пути.
     */
    @Test
    public void whenMoveBishopDiagonalFreeWayWhenMove() {
        Board board = new Board();
        board.add(new BishopBlack(F8));
        boolean result = board.move(F8, C5);
        assertThat(result, is(true));
    }

    /**
     * Тест, проверяющий, что в исходной клетке нет фигуры.
     * Выбрасывается исключение FigureNotFoundException.
     */
    @Test
    public void whenMoveOfEmptySourceThenException() {
        Board board = new Board();
        boolean result = true;
        board.add(new PawnBlack(E7));
        if (board.move(F8, D6)) {
            result = false;
            System.out.println("В исходной клетке есть фигура");
        }
        assertTrue(result);
    }
}
