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
        boolean diagonal1 = true; //переменная с результатом по первой диагонали
        boolean diagonal2 = true; //переменная с результатом по второй диагонали
        for (int i = 0, j = 0; i < this.table.length; i++) {
            if (!this.table[i][j].hasMarkX()) {
                diagonal1 = false;
                break;
            }
            j++;
        }
        for (int i = 0, j = this.table.length - 1; i < this.table.length; i++) {
            if (!this.table[i][j].hasMarkX()) {
                diagonal2 = false;
                break;
            }
            j--;
        }
        return (diagonal1 || diagonal2);
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
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkX()) {
                    row = false;
                    break;
                }
            }
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
        boolean diagonal1 = true; //переменная с результатом по первой диагонали
        boolean diagonal2 = true; //переменная с результатом по второй диагонали
        for (int i = 0, j = 0; i < this.table.length; i++) {
            if (!this.table[i][j].hasMarkO()) {
                diagonal1 = false;
                break;
            }
            j++;
        }
        for (int i = 0, j = this.table.length - 1; i < this.table.length; i++) {
            if (!this.table[i][j].hasMarkO()) {
                diagonal2 = false;
                break;
            }
            j--;
        }
        return (diagonal1 || diagonal2);
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
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkO()) {
                    row = false;
                    break;
                }
            }
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
	 * @return Если пустые клетки есть, вернет true, иначе false.
     */
    public boolean hasGap() {
        boolean vacant = false; //переменная с результатом проверки на пустые клетки
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
        return vacant;
    }
}
