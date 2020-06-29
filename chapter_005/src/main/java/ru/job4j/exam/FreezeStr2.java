package ru.job4j.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.06.2020
 */

/**
 * Класс для проверки двух строк на идентичность.
 * Проверить, что вторая строка получилась методом перестановок символов в первой строке.
 */
public class FreezeStr2 {
    public static boolean eq(String left, String right) {
        boolean result = false;
        if (left.length() == right.length()) {
            List<Character> leftList = new ArrayList<>();
            List<Character> rightList = new ArrayList<>();
            for (int i = 0; i < left.length(); i++) {
                addValueToList(leftList, left.toCharArray()[i]);
                addValueToList(rightList, right.toCharArray()[i]);
            }
            Collections.sort(leftList);
            Collections.sort(rightList);
            if (leftList.equals(rightList)) {
                result = true;
            }
        }
        return result;
    }

    public static void addValueToList(List list, char key) {
        list.add(key);
    }
}
