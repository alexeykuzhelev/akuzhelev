package ru.job4j.sort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 22.02.2019
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
        users.add(new User("Петя", 30));
        users.add(new User("Денис", 25));
        users.add(new User("Оля", 20));
        Set<User> result = sortUser.sort(users);
        String expect = "[Оля возраст:20, Денис возраст:25, Петя возраст:30]";
        assertThat(result.toString(), is(expect));
    }
}
