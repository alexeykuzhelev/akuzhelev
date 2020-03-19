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
 * @since 19.03.2020
 */

/**
 * Класс тестирует поведение карты, если в нее добавляются объекты,
 * у которых переопределен только Equals.
 */
public class UserOverrideEqualsTest {

    /**
     * Объяснение:
     * В карту добавились 2 объекта, потому что хэш-коды ключей user1 и user2 не равны друг другу.
     * Они не равны, так как:
     * При добавлении методом put первая часть условия требует, чтобы хэш-коды совпадали:
     * if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
     * А метод hashCode по-умолчанию для двух разных объектов дает false.
     * Если hashCode false, то до второй части условия - метода equals, даже не доходим.
     * Поэтому, для разных ключей - две записи в map.
     * Результат вывода на печать: {ru.job4j.map.UserOverrideEquals@8c92f4=java.lang.Object@1c6c3b2, ru.job4j.map.UserOverrideEquals@1e4705b=java.lang.Object@533e64}
     */
    @Test
    public void whenOverridedOnlyEqualsThenPrintsTwoUser() {
        User user1 = new UserOverrideEquals("Aleks", 1, new GregorianCalendar(1977, 6, 07));
        User user2 = new UserOverrideEquals("Aleks", 1, new GregorianCalendar(1977, 6, 07));
        Map<User, Object> users = new HashMap<>();
        users.put(user1, new Object());
        users.put(user2, new Object());
        assertThat(user1.equals(user2), is(true));
        assertThat(user1.hashCode() == user2.hashCode(), is(false));
        System.out.println(users);
    }
}
