package ru.job4j.tracker.start;

import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 03.08.2018
 */

/**
 * Класс ConsoleInput используется для ввода пользовательских данных из консоли.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in); //объект класса Scanner

    /**
     * Метод спросить пользователя.
     * @param question вопрос пользователю.
     * @return ответ пользователя (ключ).
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    /**
     * Метод спросить пользователя.
     * @param question вопрос пользователю.
     * @param range массив со значениями ключа.
     * @return ответ пользователя (ключ).
     */
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        return key;
    }
}
