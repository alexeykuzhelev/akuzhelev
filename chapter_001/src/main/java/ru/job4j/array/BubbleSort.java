package ru.job4j.array;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 02.04.2018
 */

public class BubbleSort {
	/**
	 * Сортировка массива методом перестановки.
	 */
	public int[] sort(int[] array) {
		/*Внешний цикл каждый проход сокращает фрагмент сортируемого массива, 
		  так как внутренний цикл каждый проход ставит в конец фрагмента 
          максимальный элемент, который не участвует в дальнейшей сортировке.
		  В итоге, наименьший элемент постепенно перемещается  к началу массива.*/
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				/*Сравниваем попарно соседние элементы. 
				  Если они имеют неправильный порядок (второй меньше первого), 
				  то меняем местами через промежуточную переменную.*/
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
		return array;
	}
}
