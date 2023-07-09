package ru.job4j.loop;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 10.03.2018
 */

/**
 * Вычислить факториал для числа n.
 */

public class Factorial {
	/* в метод приходит положительное целое число n, сам метод должен возвращать рассчитанный
	 факториал для этого числа */
	public int calc(int n) {
		int fact = 1;
		for (int number = 1; number <= n; ++number) { /* Умножаем, пока number <= числу n.*/
			fact *= number;                          /* это сокращение для fact = fact * number*/
		}
		return fact;                            /* возвращаем методу вычисленный выше факториал*/
	}
}
