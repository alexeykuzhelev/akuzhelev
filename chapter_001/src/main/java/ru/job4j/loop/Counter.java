package ru.job4j.loop;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 09.03.2018
 */

/**
 * Подсчет суммы четных чисел в диапазоне.
 */
 
public class Counter {
    public int add(int start, int finish) {
		int sumEven = 0; // сумма четных чисел
		for(int number = start; number <= finish; number++) {
		// если деление на 2 с остатком, в остатке 0, то =>
		    if(number % 2 == 0) {
			    sumEven = sumEven + number; // накапливать сумму четных чисел
		    }
		}
		return sumEven;
	}
}
