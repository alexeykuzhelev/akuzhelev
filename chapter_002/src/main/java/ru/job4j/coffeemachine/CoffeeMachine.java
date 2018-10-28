package ru.job4j.coffeemachine;

import java.util.*;
import java.lang.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 28.10.2018
 */

/**
 * Класс, реализующий выдачу сдачи для автомата.
 */
public class CoffeeMachine {
	/**
	 * Метод выдачи сдачи для автомата.
	 * int[] coinValue - маассив с номиналами монет в автомате.
	 * @param value - номинал купюры 50 100 и т.д.
	 * @param price - цена кофе.
	 * count - счетчик того, сколько раз купюра входит в данную сумму.
	 */
	List<Integer> changes(int value, int price) {
		int[] coinValue = {1, 2, 5, 10, 50, 100};
		int change = value - price;
		int k = coinValue.length;
		while (k != 0 && coinValue[--k] > change)
			;
		int j = k;
		int tempChange, count;
		List<Integer> result = new ArrayList<>();
		do {
			if ((tempChange = change % coinValue[j]) >= coinValue[0] || tempChange == 0) {
				count = change / coinValue[j];
				change = tempChange;
			} else {
				count = change / coinValue[j] - 1;
				change = tempChange + coinValue[j];
			}
			for (int n = 0; n < count; n++) {
				result.add(coinValue[j]);
			}
			while (j != 0 && coinValue[--j] > change)
				;
		} while (k != 0 && change > 0);
		System.out.println(result);
		return result;
	}

	public static void main (String[] args) {
		CoffeeMachine coffeemachine = new CoffeeMachine();
		coffeemachine.changes(50, 35);
	}
}
