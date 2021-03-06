package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 21.01.2019
 */

/**
 * Конвертер ArrayList в двумерный массив.
 */
public class ConvertList2Array {
    /**
     * Метод конвертирует переданный список в двумерный массив (разбивает на строки).
     *
     * @param list - список.
     * @param rows - количество рядов в массиве.
     * @return - двумерный массив.
     * cells - количество элементов в строке.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows + (list.size() % rows == 0 ? 0 : 1);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer value : list) {
            array[row][cell] = value;
            cell++;
            if (cell >= cells) {
                row++;
                cell = 0;
            }
        }
        return array;
    }

    /**
     * Метод конвертирует лист массивов в один лист Integer.
     * @param list - список массивов.
     * @return - общий лист Integer.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array: list) {
            for (int value: array) {
                result.add(value);
            }
        }
        return result;
    }
}
