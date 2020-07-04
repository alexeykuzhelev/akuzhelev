package ru.job4j.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 04.07.2020
 */

/**
 * Класс для проверки двух строк на идентичность.
 * Проверить, что вторая строка получилась методом перестановок символов в первой строке.
 */
public class FreezeStr4 {

    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        int count = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            char tmpLeft = left.charAt(i);
            if (map.containsKey(tmpLeft)) {
                map.put(tmpLeft, map.get(tmpLeft) + count);
            } else {
                map.put(tmpLeft, count);
            }
        }
        for (int i = 0; i < right.length(); i++) {
            char tmpRight = right.charAt(i);
            if (!map.containsKey(tmpRight) || map.get(tmpRight) == 0) {
                return false;
            }
            map.put(tmpRight, map.get(tmpRight) - 1);
        }
        return true;
    }
}
