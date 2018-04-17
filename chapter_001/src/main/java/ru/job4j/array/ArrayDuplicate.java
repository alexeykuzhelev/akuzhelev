package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 17.04.2018
 */

public class ArrayDuplicate {
    /**
     * Удаление дубликатов в массиве
     * @param array - исходный массив с дубликатами.
     * @return - массив без дубликатов.
     */
    public String[] remove(String[] array) {
        //вводим переменную для обозначения размера массива
        int size = array.length;
        for (int i = 0; i < size; i++) {
			/*Значение индекса i во внутреннем цикле сравнивается с каждым 
			последующим элементом массива, проходя его до конца.*/
            for (int j = i + 1; j < size; j++) {
				/*Если соседние элементы дубликаты, то меняем местами через 
				промежуточную переменную значения дубликата и
				последнего элемента массива.*/
                if(array[i].equals(array[j])) {
                    String tmp = array[j];
                    array[j] = array[size - 1];
                    array[size - 1] = tmp;
                    //сокращаем размер сортируемого массива на 1
                    size--;
					/*Уменьшаем j на 1, т.к. повторно сравниваем те же индексы,
					но на месте дубликата будет значение последнего элемента.*/
                    j--;
                }
            }
        }
        //возвращаем массив-копию новой длины без дубликатов
        return Arrays.copyOf(array, size);
    }
}
