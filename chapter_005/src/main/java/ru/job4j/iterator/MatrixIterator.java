package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.11.2019
 */

/**
 * Класс реализует итератор для двухмерного массива.
 */
public class MatrixIterator implements Iterator {

    private final int[][] array;
    private int i = 0;
    private int j = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return this.array.length > i;
    }

    @Override
    public Integer next() {
        int position;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        position = this.array[i][j];
        movePosition();
        return position;
    }

    /**
     * Метод реализует сдвиг индекса в массиве на одну позицию вперед.
     */
    private void movePosition() {
        if (this.array[i].length - 1 > j) {
            j++;
        } else {
            i++;
            j = 0;
        }
    }
}
