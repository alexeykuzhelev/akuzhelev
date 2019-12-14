package ru.job4j.calculate;

import java.util.Arrays;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 30.10.2019
 */

/**
 * Класс реализует операции над массивом чисел с помощью Stream API.
 */
public class StreamApi {

    /**
     * Метод фильтрует четные числа, возводит их в квадрат и суммирует.
     * @param arr - массив чисел.
     * @return число, полученное в результате подсчета.
     */
    public int calculate(int[] arr) {
        return Arrays.stream(arr).filter(s -> s % 2 == 0)
                .reduce(0, (x, y) -> x + y * y);
    }
}
