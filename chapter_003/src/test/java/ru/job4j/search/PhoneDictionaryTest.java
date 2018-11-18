package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 18.11.2018
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
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тест, проверяющий поиск по адресу.
     */
    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Bryansk");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    /**
     * Тест, проверяющий поиск по телефону.
     */
    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("534872");
        assertThat(persons.iterator().next().getAddress(), is("Bryansk"));
    }
}
