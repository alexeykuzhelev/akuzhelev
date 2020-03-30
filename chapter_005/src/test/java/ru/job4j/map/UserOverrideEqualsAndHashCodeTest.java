package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 31.03.2020
 */

/**
 * Класс тестирует поведение карты, если в нее добавляются объекты,
 * у которых переопределен и Equals и HashCode.
 */
public class UserOverrideEqualsAndHashCodeTest {

    /**
     * Объяснение:
     * В карту добавился 1 объект, потому что у ключей user1 и user2 совпадают и хэш-коды и equals.
     * Поэтому добавление второй записи не происходит, а происходит замена значения у первого ключа.
     * Результаты вывода на печать:
     * {ru.job4j.map.UserOverrideEqualsAndHashCode@e1c6396b=java.lang.Object@a8ceb6}
     * user1.equals(user2)) = true
     * user1.hashCode() = -507102869, user2.hashCode() = -507102869
     */
    @Test
    public void whenOverridedEqualsAndHashCodeThenPrintsOneUser() {
        User user1 = new UserOverrideEqualsAndHashCode("Aleks", 1, new GregorianCalendar(1977, 6, 07));
        User user2 = new UserOverrideEqualsAndHashCode("Aleks", 1, new GregorianCalendar(1977, 6, 07));
        Map<User, Object> users = new HashMap<>();
        users.put(user1, new Object());
        users.put(user2, new Object());
        assertThat(user1.equals(user2), is(true));
        assertThat(user1.hashCode() == user2.hashCode(), is(true));
        System.out.println(users);
        System.out.println("user1.equals(user2)) = " + user1.equals(user2));
        System.out.println("user1.hashCode() = " + user1.hashCode() + ", user2.hashCode() = " + user2.hashCode());
    }
}
