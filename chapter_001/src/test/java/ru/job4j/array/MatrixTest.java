package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 05.04.2018
 */

public class MatrixTest {
	@Test
	public void whenArrayWithSizeTwoThenMultiplyIndex() {
		/*тест, проверяющий заполняемость массива размером 2 элементами таблицы умножения*/
		Matrix matrix = new Matrix();
		int[][] result = matrix.multiple(2);
		int[][] expect = {
				{1, 2},
				{2, 4},
		};
		assertThat(result, is(expect));
	}

	@Test
	public void whenArrayWithSizeFourThenMultiplyIndex() {
		/*тест, проверяющий заполняемость массива размером 4 элементами таблицы умножения*/
		Matrix matrix = new Matrix();
		int[][] result = matrix.multiple(4);
		int[][] expect = {
				{1, 2, 3, 4},
				{2, 4, 6, 8},
				{3, 6, 9, 12},
				{4, 8, 12, 16}
		};
		assertThat(result, is(expect));
	}
}
