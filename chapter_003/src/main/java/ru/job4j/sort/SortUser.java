package ru.job4j.sort;

import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 25.02.2019
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

    /**
     * Метод сортирует список List<User> по длине имени.
     * Он делает это, переопределяя Comparator для метода Collections.sort.
     * @param users - переданный список пользователей.
     * @return отсортированный список.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return Integer.compare(user1.getName().length(), user2.getName().length());
            }
        });
        return users;
    }

    /**
     * Метод сортирует список List<User> по имени в лексикографическом порядке, потом по возрасту.
     * Он делает это, переопределяя Comparator для метода Collections.sort.
     * @param users - переданный список пользователей.
     * @return отсортированный список.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int result = user1.getName().compareTo(user2.getName());
                return result != 0 ? result : user1.compareTo(user2);
            }
        });
        return users;
    }
}
