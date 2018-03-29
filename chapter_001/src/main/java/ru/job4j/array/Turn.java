package ru.job4j.array;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.03.2018
 */

public class Turn {
    /**
     * Перевернуть массив задом наперёд.
     */
    public int[] back(int[] array) {
        //создадим промежуточную переменную в виде нового массива
        int[] arrayInvert = new int[array.length];
        for(int i = array.length - 1; i >= 0; i--) {
            //присваиваем индексу нового массива значение индекса старого массива
            //индекс нового массива начинается с нуля, а индекс старого массива с конца
            arrayInvert[array.length - 1 - i] = array[i];
        }
        for(int a = 0; a < array.length; a++){
            //здесь вводим новую переменную a и присваиваем массиву array значение
            //массива arrayInvert, вычисленное выше
            array[a] = arrayInvert[a];
        }
        return array;
    }
}
