package ru.job4j.io;

import java.util.Arrays;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.11.2021
 */

/**
 * Класс содержит информацию о некотором человеке.
 */
public class Person {
    private final boolean genderMan;
    private final int age;
    private final String name;
    private final Contact contact;
    private final String[] ids;

    public Person(boolean genderMan, int age, String name, Contact contact, String[] ids) {
        this.genderMan = genderMan;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "Person{"
            + "genderMan=" + genderMan
            + ", age=" + age
            + ", name=" + name
            + ", contact=" + contact
            + ", ids=" + Arrays.toString(ids)
            + '}';
    }
}
