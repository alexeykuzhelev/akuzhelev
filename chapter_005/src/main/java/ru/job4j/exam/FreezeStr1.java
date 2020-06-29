package ru.job4j.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.06.2020
 */

/**
 * Класс для проверки двух строк на идентичность.
 * Проверить, что вторая строка получилась методом перестановок символов в первой строке.
 */
public class FreezeStr1 {
    public static boolean eq(String left, String right) {
        boolean result = false;
        if (left.length() == right.length()) {
            Map<Character, Integer> leftMap = new HashMap<>();
            Map<Character, Integer> rightMap = new HashMap<>();
            for (int i = 0; i < left.length(); i++) {
                addValueToMap(leftMap, left.toCharArray()[i]);
                addValueToMap(rightMap, right.toCharArray()[i]);
            }
            result = leftMap.equals(rightMap);
        }
        return result;
    }

    public static void addValueToMap(Map map, char key) {
        int value = (int) map.getOrDefault(key, 0);
        map.put(key, ++value);
    }
}
