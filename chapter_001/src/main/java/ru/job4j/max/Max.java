package ru.job4j.max;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 04.03.2018
 */

/**
 * Определить, какое из трех чисел больше.
 */
public class Max {
    // если first > second, то возвращает first, иначе возврашает second.
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
    public int max(int first, int second, int third) {
        // метод возвращает максимальное из трех чисел.
        return max(max(first, second), third);
    }
}