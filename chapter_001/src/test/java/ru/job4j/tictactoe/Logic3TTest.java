package ru.job4j.tictactoe;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 03.04.2018
 */

public class Logic3TTest {

    @Test
    public void whenHasXWinnerDiagonalRight() {
        //тест проверяет, что диагональ выигрышная для Крестика
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXWinnerVert1() {
        //тест проверяет, что вертикаль №1 выигрышная для Крестика
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(true), new Figure3T(true), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXWinnerDiagonalLeft() {
        //тест проверяет, что диагональ выигрышная для Крестика
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T(true)},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(true), new Figure3T(false), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasOWinnerVert0() {
        //тест проверяет, что вертикаль №0 выигрышная для Нолика
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(true), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasOWinnerHoriz2() {
        //тест проверяет, что горизонталь №2 выигрышная для Нолика
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasOWinnerDiagonalLeft() {
        //тест проверяет, что диагональ выигрышная для Нолика
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasGasYes() {
        //тест проверяет, что пустые клетки есть (true)
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }

    @Test
    public void whenHasGasNo() {
        //тест проверяет, что пустых клеток нет (false)
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(false), new Figure3T(true)},
                {new Figure3T(true), new Figure3T(true), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(false));
    }
}