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
 * @since 03.10.2018
 */

/**
 * Класс BishopBlackTest содержит JUnit тесты для для тестирования хода фигуры Слон.
 */
public class BishopBlackTest {
    /**
     * Тест, проверяющий невозможность хода Слона, если на его пути стоит другая фигура.
     * Выбрасывается исключение OccupiedWayException, если ход невозможен.
     */
    @Test (expected = OccupiedWayException.class)
    public void whenMoveBishopThroughPawnWhenException() {
        Board board = new Board();
        board.add(new PawnBlack(E7));
        board.add(new BishopBlack(F8));
		board.move(F8, B4);
    }

    /**
     * Тест, проверяющий неправильность хода Слона без других фигур на его пути.
     * Выбрасывается исключение ImpossibleMoveException, если Слон не может так ходить.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveBishopVerticalFreeWayWhenException() {
        Board board = new Board();
        board.add(new BishopBlack(F8));
		board.move(F8, F6);
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
    @Test (expected = FigureNotFoundException.class)
    public void whenMoveOfEmptySourceThenException() {
        Board board = new Board();
        board.add(new PawnBlack(E7));
		board.move(F8, D6);
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
    @Test (expected = OccupiedWayException.class)
    public void whenMoveBishopFullWayThroughPawnWhenException() {
        BishopBlack bishop = new BishopBlack(A1);
        Board board = new Board();
        board.add(new PawnBlack(G7));
        board.add(new BishopBlack(A1));
        Cell[] result = bishop.way(bishop.position(), H8);
        Cell[] expected = {B2, C3, D4, E5, F6, G7, H8};
        if (!(result.equals(expected))) {
            System.out.println("Слон не может ходить через фигуру");
            board.move(bishop.position(), H8);
        }
    }

    /**
     * Тест на полный путь, проверяющий неправильность хода Слона без других фигур на его пути.
     * Выбрасывается исключение ImpossibleMoveException, если Слон не может так ходить.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveBishopFullWayVerticalFreeWayWhenException() {
        BishopBlack bishop = new BishopBlack(A1);
        Board board = new Board();
        board.add(new BishopBlack(A1));
        Cell[] result = bishop.way(bishop.position(), H8);
        Cell[] expected = {B2, C3, D4, E5, F6, G7, H8};
        if (!(result.equals(expected))) {
            System.out.println("Слон не может так ходить");
            board.move(A1, A3);
        }
    }

    /**
     * Тест на полный путь, проверяющий, что в исходной клетке нет фигуры.
     * Выбрасывается исключение FigureNotFoundException.
     */
    @Test (expected = FigureNotFoundException.class)
    public void whenMoveFullWayOfEmptySourceThenException() {
        BishopBlack bishop = new BishopBlack(A1);
        Board board = new Board();
        board.add(new PawnBlack(B2));
        Cell[] result = bishop.way(bishop.position(), H8);
        Cell[] expected = {B2, C3, D4, E5, F6, G7, H8};
        if (!(result.equals(expected))) {
            System.out.println("В исходной клетке нет фигуры");
            board.move(F8, D6);
        }
    }
}
