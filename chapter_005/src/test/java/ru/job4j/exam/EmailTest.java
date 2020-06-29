package ru.job4j.exam;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.06.2020
 */

/**
 * Тестирование алгоритма, выполняющего слияние пользователей по их email-ам.
 */
public class EmailTest {

    @Test
    public void whenMergedUsers() {
        List<Email.User> users = new ArrayList<>();
        users.add(new Email.User("user1", Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        users.add(new Email.User("user2", Arrays.asList("foo@gmail.com", "ups@pisem.net")));
        users.add(new Email.User("user3", Arrays.asList("xyz@pisem.net", "vasya@pupkin.com")));
        users.add(new Email.User("user4", Arrays.asList("ups@pisem.net", "aaa@bbb.ru")));
        users.add(new Email.User("user5", Arrays.asList("xyz@pisem.net")));
        Map<String, Set<String>> result = Email.merge(users);
        Map<String, Set<String>> expected = new HashMap<>();
        expected.put("user1", new HashSet(Arrays.asList("aaa@bbb.ru", "ups@pisem.net", "lol@mail.ru", "xxx@ya.ru", "foo@gmail.com")));
        expected.put("user3", new HashSet(Arrays.asList("vasya@pupkin.com", "xyz@pisem.net")));
        assertThat(result, is(expected));
    }
}
