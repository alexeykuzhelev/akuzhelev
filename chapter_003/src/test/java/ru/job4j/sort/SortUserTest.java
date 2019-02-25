package ru.job4j.sort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 25.02.2019
 */

/**
 * Тестирование класса SortUserTest.
 */
public class SortUserTest {
    /**
     * Тест проверяет сортировку пользователей по возрасту.
     */
    @Test
    public void whenSortUserByAge() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Петя", 35));
        users.add(new User("Денис", 40));
        users.add(new User("Владимир", 30));
        users.add(new User("Даша", 40));
        Set<User> result = sortUser.sort(users);
        String expect = "[Владимир возраст:30, Петя возраст:35, Даша возраст:40, Денис возраст:40]";
        assertThat(result.toString(), is(expect));
    }

    /**
     * Тест проверяет сортировку пользователей по длине имени.
     */
    @Test
    public void whenSortUserByLengthName() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Владимир", 35));
        users.add(new User("Оля", 20));
        users.add(new User("Денис", 25));
        users.add(new User("Петя", 30));
        List<User> result = sortUser.sortNameLength(users);
        String expect = "[Оля возраст:20, Петя возраст:30, Денис возраст:25, Владимир возраст:35]";
        assertThat(result.toString(), is(expect));
    }

    /**
     * Тест проверяет сортировку пользователей по имени в лексикографическом порядке, потом по возрасту.
     */
    @Test
    public void whenSortUserByNameAndByAge() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Сергей", 25));
        users.add(new User("Иван", 30));
        users.add(new User("Сергей", 20));
        users.add(new User("Иван", 25));
        List<User> result = sortUser.sortByAllFields(users);
        String expect = "[Иван возраст:25, Иван возраст:30, Сергей возраст:20, Сергей возраст:25]";
        assertThat(result.toString(), is(expect));
    }
}
