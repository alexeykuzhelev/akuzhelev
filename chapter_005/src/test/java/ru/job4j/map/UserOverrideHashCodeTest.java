package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.03.2020
 */

/**
 * Класс тестирует поведение карты, если в нее добавляются объекты,
 * у которых переопределен только HashCode.
 */
public class UserOverrideHashCodeTest {

	/**
	 * Объяснение:
	 * В карту добавились 2 объекта, потому что ключи user1 и user2 не равны друг другу.
	 * Они не равны, так как:
	 * Хотя hashcode для двух объектов совпадают, но этого мало, чтобы признать ключи равными друг другу!
	 * Потому-что метод equals по-умолчанию для двух разных объектов дает false:
	 *    public boolean equals(Object obj) {
	 *        return (this == obj);
	 *   }
	 * Поэтому, для разных ключей - две записи в map.
	 * Результат вывода на печать: {ru.job4j.map.UserOverrideHashCode@e1c6396b=java.lang.Object@a8ceb6, ru.job4j.map.UserOverrideHashCode@e1c6396b=java.lang.Object@530c12}
	 */
	@Test
	public void whenOverridedOnlyHashCodeThenPrintsTwoUser() {
		User user1 = new UserOverrideHashCode("Aleks", 1, new GregorianCalendar(1977, 6, 07));
		User user2 = new UserOverrideHashCode("Aleks", 1, new GregorianCalendar(1977, 6, 07));
		Map<User, Object> users = new HashMap<>();
		users.put(user1, new Object());
		users.put(user2, new Object());
		assertThat(user1.equals(user2), is(false));
		assertThat(user1.hashCode() == user2.hashCode(), is(true));
		System.out.println(users);
	}
}
