package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 19.04.2018
 */

public class ArrayDuplicate {
    /**
     * Удаление дубликатов в массиве
     * @param array - исходный массив с дубликатами.
     * @return - массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[size - 1];
                    size--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, size);
    }
}
