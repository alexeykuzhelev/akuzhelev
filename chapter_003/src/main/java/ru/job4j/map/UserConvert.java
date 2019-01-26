package ru.job4j.map;

import java.util.HashMap;
import java.util.List;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 27.01.2019
 */

/**
 * Класс преобразует List в Map.
 */
public class UserConvert {
    /**
     * Метод принимает в себя список пользователей и конвертирует его в Map.
     * @param list - список пользователей.
     * @return - Map.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> users = new HashMap<>();
        for (User user : list) {
            Integer id = user.getId();
            users.put(id, user);
        }
        return users;
    }
}
