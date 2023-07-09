package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 02.04.2018
 */

public class BubbleSortTest {
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		/*тест, проверяющий сортировку массива из 10 элементов методом пузырька.*/
		BubbleSort bubble = new BubbleSort();
		int[] input = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
		int[] result = bubble.sort(input);
		int[] expect = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
		assertThat(result, is(expect));
	}
}
