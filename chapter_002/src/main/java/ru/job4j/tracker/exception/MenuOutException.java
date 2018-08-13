package ru.job4j.tracker.exception;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 13.08.2018
 */

/**
 * Класс MenuOutException реализует выдачу сообщения об исключении.
 * Родительский класс RuntimeException реализует исключения, которые не обрабатываются.
 */
public class MenuOutException extends RuntimeException {
    /**
     * Конструктор.
     * @param msg сообщение об ошибке.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
