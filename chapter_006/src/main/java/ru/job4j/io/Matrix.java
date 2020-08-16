package ru.job4j.io;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 16.08.2020
 */

/**
 * Класс реализует таблицу умножения в виде двухмерного массива (матрицы).
 */
public class Matrix {
	/**
	 * В элементах таблицы записать элементы таблицы умножения.
	 * Создаем двумерный массив размерностью size.
	 * Первый цикл идет по строкам, второй по столбцам таблицы.
	 * Инициализируем элементы массива перемножением их индексов,
	 * при этом к индексам нужно добавить 1, т.к. они начинаются с 0.
	 * @param size - указывает на размер таблицы
	 */
	public int[][] multiple(int size) {
		int[][] array = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = (i + 1) * (j + 1);
			}
		}
		return array;
	}
}
