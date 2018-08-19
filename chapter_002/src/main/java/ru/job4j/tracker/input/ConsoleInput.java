package ru.job4j.tracker.input;

import ru.job4j.tracker.exception.*;
import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 13.08.2018
 */

/**
 * Класс ConsoleInput используется для ввода пользовательских данных из консоли.
 */
public class ConsoleInput implements Input {
    /**
     * Объект класса Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод спросить пользователя.
     * @param question вопрос пользователю.
     * @return ответ пользователя (ключ).
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    /**
     * Метод спросить пользователя.
     * @param question вопрос пользователю.
     * @param range массив со значениями ключа.
     * @return ответ пользователя (ключ).
	 * @exception MenuOutException создаем необрабатываемое исключение.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
