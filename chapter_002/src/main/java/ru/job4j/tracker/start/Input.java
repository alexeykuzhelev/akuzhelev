package ru.job4j.tracker.start;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 24.06.2018
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
}
