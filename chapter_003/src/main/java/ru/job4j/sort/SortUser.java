package ru.job4j.sort;

import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 22.02.2019
 */

/**
 * Класс сортирует пользователей.
 */
public class SortUser {
    /**
     * Метод сортирует список пользователей по возрасту в порядке возрастания.
     * @param users - переданный список пользователей.
     * @return - TreeSet - отсортированное множество.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}
