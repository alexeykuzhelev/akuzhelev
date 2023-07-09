package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 17.04.2018
 */

public class ArrayDuplicateTest {
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		/*тест, проверяющий удаление дубликатов строк из массива строк.*/
		ArrayDuplicate dup = new ArrayDuplicate();
		String[] input = {"Привет", "Вася", "Привет", "Мир", "Вася"};
		String[] result = dup.remove(input);
		String[] expect = {"Привет", "Вася", "Мир"};
		assertThat(result, is(expect));
	}
}
