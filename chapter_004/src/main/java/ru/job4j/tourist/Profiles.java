package ru.job4j.tourist;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.07.2019
 */

/**
 * Класс позволяет получить список адресов клиентов используя Stream API и метод map.
 */
public class Profiles {
    /**
     * Метод получает список адресов клиентов из списка их профилей.
     * @param profiles - список профилей клиентов.
     * @return - список адресов клиентов.
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
    }
}
