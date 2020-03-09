package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 09.03.2020
 */

/**
 * Класс тестирует поведение карты, если в нее добавляются объекты,
 * у которых не переопределен ни Equals, ни HashCode.
 */
public class UserTest {

	/**
	 * Объяснение:
	 * В карту добавились 2 объекта, потому что ключи user1 и user2 не равны друг другу.
	 * Они не равны, так как:
	 * Во первых - метод equals по-умолчанию для двух разных объектов дает false,
	 * в виду того, что ссылки в них указывают на разные объекты и следовательно не равны:
	 *    public boolean equals(Object obj) {
	 *        return (this == obj);
	 *   }
	 * Во вторых - hashcode по-умолчанию нативный метод и тоже даст разные значения.
	 * Этот метод реализован как конвертация внутреннего адреса объекта в число,
	 * т.е. для разных адресов будет разные значения hashcode.
	 * Поэтому, для разных ключей - две записи в map.
	 * Результат вывода на печать: 
	 * {ru.job4j.map.User@14fb997=java.lang.Object@93a7ca, ru.job4j.map.User@1eb6432=java.lang.Object@182c5f3}
	 */
	@Test
	public void whenNotOverrideHashCodeAndEqualsThenPrintsTwoUser() {
		User user1 = new User("Aleks", 1, new GregorianCalendar(1977, 6, 07));
		User user2 = new User("Aleks", 1, new GregorianCalendar(1977, 6, 07));
		Map<User, Object> users = new HashMap<>();
		users.put(user1, new Object());
		users.put(user2, new Object());
		assertThat(user1.equals(user2), is(false));
		assertThat(user1.hashCode() == user2.hashCode(), is(false));
		System.out.println(users);
	}
}
