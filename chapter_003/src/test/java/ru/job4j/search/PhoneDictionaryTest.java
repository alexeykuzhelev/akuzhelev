package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 06.09.2019
 */

/**
 * Класс PhoneDictionary тестирует поиск по телефонному справочнику.
 */
public class PhoneDictionaryTest {
    /**
     * Тест, проверяющий поиск по имени.
     */
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тест, проверяющий поиск по адресу.
     */
    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Bryansk");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    /**
     * Тест, проверяющий поиск по телефону.
     */
    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("534872");
        assertThat(persons.iterator().next().getAddress(), is("Bryansk"));
    }
}
