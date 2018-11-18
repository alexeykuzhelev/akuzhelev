package ru.job4j.search;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 18.11.2018
 */

/**
 * Класс Person содержит поля и методы пользователя.
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
