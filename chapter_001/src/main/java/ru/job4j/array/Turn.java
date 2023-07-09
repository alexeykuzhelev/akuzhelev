package ru.job4j.array;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 30.03.2018
 */

public class Turn {
    /**
     * Перевернуть массив задом наперёд.
     */
    public int[] back(int[] array) {
        for (int i = array.length - 1; i >= array.length / 2; i--) {
            /*в цикле через промежуточную переменную меняем местами элементы массива
            промежуточная переменная убывает начиная с конца массива*/
            int tmp = array[i];
            /*присвоение значений с конца массива*/
            array[i] = array[array.length - 1 - i];
            /*присвоение значений с начала массива*/
            array[array.length - 1 - i] = tmp;
        }
        return array;
    }
}
