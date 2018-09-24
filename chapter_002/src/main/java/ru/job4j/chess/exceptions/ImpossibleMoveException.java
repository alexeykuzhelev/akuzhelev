package ru.job4j.chess.exceptions;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 20.09.2018
 */
 
/**
 * Класс реализует выдачу сообщения об исключении, созданном нами самими.
 * Исключение возникает, когда фигура не может пойти в заданную клетку.
 * Родительский класс RuntimeException реализует исключения, которые не обрабатываются.
 */
public class ImpossibleMoveException extends RuntimeException {
    /**
     * Конструктор.
     * @param msg сообщение об ошибке.
     */	
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
