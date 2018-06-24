package ru.job4j.tracker.start;

import java.util.Scanner;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 24.06.2018
 */

/**
 * Класс ConsoleInput используется для ввода пользовательских данных из консоли.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in); //объект класса Scanner

    /**
     * Метод спросить пользователя.
     * @param question вопрос пользователю.
     * @return ответ пользователя.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
