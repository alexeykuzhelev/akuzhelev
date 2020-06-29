package ru.job4j.exam;

import java.util.Arrays;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.06.2020
 */

/**
 * Класс для проверки двух строк на идентичность.
 * Проверить, что вторая строка получилась методом перестановок символов в первой строке.
 */
public class FreezeStr3 {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        } else {
            char[] chLeft = left.toCharArray();
            char[] chRight = right.toCharArray();
            Arrays.sort(chLeft);
            Arrays.sort(chRight);
            String strLeft = new String(chLeft);
            String strRight = new String(chRight);
            return strLeft.equals(strRight);
        }
    }
}
