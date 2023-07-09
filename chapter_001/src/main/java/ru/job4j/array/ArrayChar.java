package ru.job4j.array;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 13.04.2018
 */

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;
    /*Преобразуем строку line в новый массив символов и присвоим его
    массиву data.
    @param line - строка, содержащая полное слово*/
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Метод проверяет, что слово начинается с префикса.
     * @param prefix префикс - строка содержащая часть слова.
     * @return - истинность или ложность того, что слово начинаеться с префикса.
     */
    public boolean startsWith(String prefix) {
        boolean result = true;
        /*Преобразуем строку prefix в новый массив символов и присвоим его
        массиву value.*/
        char[] value = prefix.toCharArray();
        /*Проверить, что массив data имеет первые элементы одинаковые с value.
        Цикл выполняется, пока не дойдем до конца префикса.*/
        for (int i = 0; i < value.length; i++) {
            if (data[i] != value[i]) {
                /*если находит несоответствие первых элементов, возвращает false*/
                result = false;
            }
        }
        /*Если все первые элементы массива data и массива value равны,
        то возвращает true*/
        return result;
    }
}
