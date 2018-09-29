package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.black.*;
import ru.job4j.chess.exceptions.*;
import ru.job4j.chess.figures.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.chess.figures.Cell.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 28.09.2018
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
        boolean result = false;
        board.add(new PawnBlack(E7));
        board.add(new BishopBlack(F8));
        try {
            board.move(F8, B4);
        } catch (OccupiedWayException owe) {
            System.out.println("Слон не может ходить через фигуру");
            result = true;
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
        boolean result = false;
        board.add(new BishopBlack(F8));
        try {
            board.move(F8, F6);
        } catch (ImpossibleMoveException ime) {
            System.out.println("Слон не может так ходить");
            result = true;
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
        boolean result = false;
        board.add(new PawnBlack(E7));
        try {
            board.move(F8, D6);
        } catch (FigureNotFoundException fnfe) {
            System.out.println("В исходной клетке нет фигуры");
            result = true;
        }
        assertTrue(result);
    }

    /**
     * Тест на полный путь, проверяющий правильность хода Слона без других фигур на его пути.
     */
    @Test
    public void whenMoveBishopDiagonalFreeFullWayWhenMove() {
        BishopBlack bishop = new BishopBlack(A1);
        Cell[] result = bishop.way(bishop.position(), H8);
        Cell[] expected = {B2, C3, D4, E5, F6, G7, H8};
        assertThat(result, is(expected));
    }

    /**
     * Тест на полный путь, проверяющий невозможность хода Слона, если на его пути стоит другая фигура.
     * Выбрасывается исключение OccupiedWayException, если ход невозможен.
     */
    @Test
    public void whenMoveBishopFullWayThroughPawnWhenException() {
        BishopBlack bishop = new BishopBlack(A1);
        Board board = new Board();
        board.add(new PawnBlack(G7));
        board.add(new BishopBlack(A1));
        Cell[] result = bishop.way(bishop.position(), H8);
        Cell[] expected = {B2, C3, D4, E5, F6, G7, H8};
        try {
            board.move(bishop.position(), H8);
        } catch (OccupiedWayException owe) {
            System.out.println("Слон не может ходить через фигуру");
        }
        assertNotEquals(result, expected);
    }

    /**
     * Тест на полный путь, проверяющий неправильность хода Слона без других фигур на его пути.
     * Выбрасывается исключение ImpossibleMoveException, если Слон не может так ходить.
     */
    @Test
    public void whenMoveBishopFullWayVerticalFreeWayWhenException() {
        BishopBlack bishop = new BishopBlack(A1);
        Board board = new Board();
        board.add(new BishopBlack(A1));
        Cell[] result = bishop.way(bishop.position(), H8);
        Cell[] expected = {B2, C3, D4, E5, F6, G7, H8};
        try {
            board.move(A1, A3);
        } catch (ImpossibleMoveException ime) {
            System.out.println("Слон не может так ходить");
        }
        assertNotEquals(result, expected);
    }

    /**
     * Тест на полный путь, проверяющий, что в исходной клетке нет фигуры.
     * Выбрасывается исключение FigureNotFoundException.
     */
    @Test
    public void whenMoveFullWayOfEmptySourceThenException() {
        BishopBlack bishop = new BishopBlack(A1);
        Board board = new Board();
        board.add(new PawnBlack(B2));
        Cell[] result = bishop.way(bishop.position(), H8);
        Cell[] expected = {B2, C3, D4, E5, F6, G7, H8};
        try {
            board.move(F8, D6);
        } catch (FigureNotFoundException fnfe) {
            System.out.println("В исходной клетке нет фигуры");
        }
        assertNotEquals(result, expected);
    }
}
