package ru.job4j.comparator;

import java.util.Comparator;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 10.03.2019
 */

/**
 * Класс поэлементно сравнивает две строки.
 */
public class ListCompare implements Comparator<String> {
    /**
     * Метод сравнивает в лексикографическом порядке и по числу символов две строки.
     * @param left - строка.
     * @param right - строка.
     * @return   0 если строки равны как лексикографически, так и по числу символов,
     *          <0 если строка left меньше, чем строка right,
     *          >0 если строка left больше, чем строка right.
     */
    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(), right.length());
        int result = 0;
        for (int i = 0; i < min && result == 0; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
