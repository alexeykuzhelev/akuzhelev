package ru.job4j.chess.exceptions;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 20.09.2018
 */
 
/**
 * Класс реализует выдачу сообщения об исключении, созданном нами самими.
 * Исключение возникает, когда фигуры не оказалось в заданной клетке.
 * Родительский класс RuntimeException реализует исключения, которые не обрабатываются.
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     * Конструктор.
     * @param msg сообщение об ошибке.
     */	
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
