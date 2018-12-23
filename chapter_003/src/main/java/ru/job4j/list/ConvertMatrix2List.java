package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 23.12.2018
 */

/**
 * Конвертер двумерного массива в ArrayList.
 */
public class ConvertMatrix2List {
    /**
     * Метод конвертирует двумерный массив целых чисел в список ArrayList.
     * @param array - двумерный массив целых чисел.
     * @return - список ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] value1 : array) {
            for (int value2 : value1) {
                list.add(value2);
            }
        }
        return list;
    }
}
