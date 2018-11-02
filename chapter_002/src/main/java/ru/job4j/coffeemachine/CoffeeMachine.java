package ru.job4j.coffeemachine;

import java.util.*;
import java.lang.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 02.11.2018
 */

/**
 * Класс, реализующий выдачу сдачи для автомата.
 */
public class CoffeeMachine {
	/**
	 * Метод выдачи сдачи для автомата.
	 * int[] coins - маассив с номиналами монет в автомате.
	 * @param value - номинал купюры 50 100 и т.д.
	 * @param price - цена кофе.
	 * change - сдача и остаток от сдачи при вычете монеты.
	 * @return List<Integer> - массив с выданными монетами.
	 */
	List<Integer> changes(int value, int price) {
		int[] coins = {100, 50, 10, 5, 2, 1};
		List<Integer> result = new ArrayList<>();
		int change = value - price;
		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			while (change - coin >= 0) {
				result.add(coin);
				change -= coin;
			}
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		CoffeeMachine coffeemachine = new CoffeeMachine();
		coffeemachine.changes(50, 35);
	}
}
