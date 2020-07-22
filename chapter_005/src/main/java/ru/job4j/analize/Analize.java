package ru.job4j.analize;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 22.07.2020
 */

/**
 * Класс реализует статистику об изменении коллекции.
 */
public class Analize {

    /**
     * Метод возвращает статистику об изменении коллекции.
     * @param previous - начальное состояние коллекции.
     * @param current - измененное состояние коллекции.
     * @return - объект класса Info, содержащий статистику по коллекции.
     */
    public Info diff(List<User> previous, List<User> current) {

        Info info = new Info();
        Map<Integer, User> currentMap = current.stream().collect(Collectors.toMap(u -> u.id, u -> u));

        for (User prevUser : previous) {
            User currentUser = currentMap.get(prevUser.id);
            if (currentUser != null) {
                if (!currentUser.equals(prevUser)) {
                    info.changed += 1;
                }
            } else {
                info.deleted += 1;
            }
        }

        info.added = current.size() - (previous.size() - info.deleted);
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            if (id != user.id) {
                return false;
            }
            return name.equals(user.name);
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + name.hashCode();
            return result;
        }
    }

    /**
     * Класс содержит статистику по коллекции.
     */
    public static class Info {
        /**
         * Число добавленных пользователей.
         */
        int added;
        /**
         * Число измененных пользователей.
         */
        int changed;
        /**
         * Число удаленных пользователей.
         */
        int deleted;
    }
}
