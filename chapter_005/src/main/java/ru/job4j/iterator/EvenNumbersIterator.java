package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 21.11.2019
 */

/**
 * Класс реализует итератор, возвращающий только четные цифры.
 */
public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] numbers;
    private int index = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Метод возвращает true, только если в массиве есть четные числа.
     */
    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        if (index < numbers.length) {
            hasNext = checkEven(index) || movePositionOnEven();
        }
        return hasNext;
    }

    /**
     * Метод возвращает только четные числа.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("no any even numbers");
        }
        return this.numbers[index++];
    }

    /**
     * Метод проверяет, является ли текущий индекс в массиве четным числом.
     * @param index - текущий индекс в массиве.
     * @return true - если индекс четное число, иначе false.
     */
    private boolean checkEven(int index) {
        return this.numbers[index] % 2 == 0;
    }

    /**
     * Метод реализует сдвиг индекса в массиве до ближайшего четного числа.
     * @return при сдвиге на четное число возвращает true.
     * Если четных чисел в массиве нет, то возвращает false.
     */
    private boolean movePositionOnEven() {
        boolean hasNext = false;
        index++;
        for (int i = index; i < this.numbers.length; i++) {
            if (checkEven(i)) {
                index = i;
                hasNext = true;
                break;
            }
        }
        if (!hasNext) {
            index = numbers.length;
        }
        return hasNext;
    }
}
