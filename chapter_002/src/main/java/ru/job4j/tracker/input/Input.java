package ru.job4j.tracker.input;

import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 03.08.2018
 */

/**
 * Interface Input реализует интрефэйс ввода.
 */
public interface Input {
    /**
     * Метод спросить пользователя.
     * @param question вопрос пользователю.
     * @return ответ пользователя.
     */
    String ask(String question);
    /**
     * Метод спросить пользователя.
     * @param question вопрос пользователю.
     * @param range массив со значениями ключа.
     * @return ответ пользователя.
     */
    int ask(String question, List<Integer> range);
}
