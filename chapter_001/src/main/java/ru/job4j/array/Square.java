package ru.job4j.array;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 23.03.2018
 */

public class Square {
    /**
     * Заполнить массив степенями чисел.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for(int i = 0; i < bound; i++) {
            result[i] = (i + 1) * (i + 1);
        }
        return result;
    }
}
