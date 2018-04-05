package ru.job4j.array;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 05.04.2018
 */

public class Matrix {
	/**
	 * В элементах таблицы записать элементы таблицы умножения.
	 * @param size - указывает на размер таблицы
	 */
	public int[][] multiple(int size) {
		//создаем двумерный массив размерностью size
		int[][] array = new int[size][size];
		//первый цикл идет по строкам таблицы
		for (int i = 0; i < size; i++) {
			//второй цикл идет по столбцам таблицы
			for (int j = 0; j < size; j++) {
				//инициализируем элементы массива перемножением их индексов
				//при этом к индексам нужно добавить 1, т.к. они начинаются с 0
				array[i][j] = (i+1)*(j+1);
			}
		}
		//вывод элементов массива
		return array;
	}
}
