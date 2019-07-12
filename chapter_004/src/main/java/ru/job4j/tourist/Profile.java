package ru.job4j.tourist;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.07.2019
 */

/**
 * Класс реализует поля и методы профиля анкеты клиента.
 */
public class Profile {

    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
