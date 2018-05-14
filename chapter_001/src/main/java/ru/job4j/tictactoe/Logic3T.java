package ru.job4j.tictactoe;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.04.2018
 */

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Метод проверяет,	есть ли в поле выигрышные комбинации для Крестика.
     */
    public boolean isWinnerX() {
        return (this.checkDiagonalX() || this.checkLinesX());
    }

    /**
     * Метод проверки по диагоналям для Крестика.
     */
    private boolean checkDiagonalX() {
        boolean diagonalRight = true; //переменная с результатом по первой диагонали
        boolean diagonalLeft = true; //переменная с результатом по второй диагонали
        //Проверяем первую диагональ
        for (int i = 0, j = 0; i < this.table.length; i++) {
            if (!this.table[i][j].hasMarkX()) {
                diagonalRight = false;
                break;
            }
            j++;
        }
        //Проверяем вторую диагональ
        for (int i = 0, j = this.table.length - 1; i < this.table.length; i++) {
            if (!this.table[i][j].hasMarkX()) {
                diagonalLeft = false;
                break;
            }
            j--;
        }
        return (diagonalRight || diagonalLeft);
    }

    /**
     * Метод проверки по горизонтали и вертикали для Крестика.
     */
    private boolean checkLinesX() {
        boolean row = true; //переменная с результатом проверки по строкам
        boolean column = true; //переменная с результатом проверки по столбцам
        for (int i = 0; i < this.table.length; i++) {
            column = true;
            row = true;
            //Проверка по строкам
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkX()) {
                    row = false;
                    break;
                }
            }
            //Проверка по столбцам
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[j][i].hasMarkX()) {
                    column = false;
                    break;
                }
            }
            if (row || column) {
                break;
            }
        }
        return (row || column);
    }

    /**
     * Метод проверяет,	есть ли в поле выигрышные комбинации для Нолика.
     */
    public boolean isWinnerO() {
        return (this.checkDiagonalO() || this.checkLinesO());
    }

    /**
     * Метод проверки по диагоналям для Нолика.
     */
    private boolean checkDiagonalO() {
        boolean diagonalRight = true; //переменная с результатом по первой диагонали
        boolean diagonalLeft = true; //переменная с результатом по второй диагонали
        //Проверяем первую диагональ
        for (int i = 0, j = 0; i < this.table.length; i++) {
            if (!this.table[i][j].hasMarkO()) {
                diagonalRight = false;
                break;
            }
            j++;
        }
        //Проверяем вторую диагональ
        for (int i = 0, j = this.table.length - 1; i < this.table.length; i++) {
            if (!this.table[i][j].hasMarkO()) {
                diagonalLeft = false;
                break;
            }
            j--;
        }
        return (diagonalRight || diagonalLeft);
    }

    /**
     * Метод проверки по горизонтали и вертикали для Нолика.
     */
    private boolean checkLinesO() {
        boolean row = true; //переменная с результатом проверки по строкам
        boolean column = true; //переменная с результатом проверки по столбцам
        for (int i = 0; i < this.table.length; i++) {
            column = true;
            row = true;
            //Проверка по строкам
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkO()) {
                    row = false;
                    break;
                }
            }
            //Проверка по столбцам
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[j][i].hasMarkO()) {
                    column = false;
                    break;
                }
            }
            if (row || column) {
                break;
            }
        }
        return (row || column);
    }

    /**
     * Метод проверяет,	есть ли пустые клетки для новых ходов.
     */
    public boolean hasGap() {
        /*Создадим логическую переменную с результатом проверки
		на пустые клетки. Считаем, что сначала пустых клеток нет.*/
        boolean vacant = false;
        /*Проходим по каждой клетке поля и если где-то есть хоть одна
		пустая клетка, то записываем в vacant true и прерываем циклы.*/
        for (int i = 0; i < this.table.length; i++) {
            vacant = false;
            for (int j = 0; j < this.table.length; j++) {
                if (!(table[i][j].hasMarkX() || this.table[i][j].hasMarkO())) {
                    vacant = true;
                    break;
                }
            }
            if (vacant) {
                break;
            }
        }
        /*Если пустые клетки есть, то вернет true.
        Если пустых клеток нет, то вернет false.*/
        return vacant;
    }
}
