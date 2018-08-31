package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.*;
import ru.job4j.tracker.storage.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 31.08.2018
 */

/**
 * Interface UserAction описывает действие пользователя.
 */
public interface UserAction {
    /**
     * Перевод на новую строку.
     */
    String LN = System.lineSeparator();

    /**
     * Метод возвращает ключ опции (идентификатор действия, которое делает пользователь).
     * @return ключ
     */
    int key();
    /**
     * Основной метод. Совершает действие, выбранное пользователем.
     * @param input объект типа Input (ввод пользователя).
     * @param tracker объект типа Tracker (хранилища заявок).
     */
    void execute(Input input, Tracker tracker);
    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню.
     */
    String info();
}
