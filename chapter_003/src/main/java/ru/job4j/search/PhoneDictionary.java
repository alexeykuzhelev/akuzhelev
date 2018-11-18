package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 18.11.2018
 */

/**
 * Класс PhoneDictionary реализует телефонный справочник.
 */
public class PhoneDictionary {
    /**
     * Массив является хранилищем для телефонного справочника.
     */
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Метод добавляет человека в телефонный справочник.
     * @param person
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person: persons) {
            if (person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getPhone().contains(key)
                    || person.getAddress().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
