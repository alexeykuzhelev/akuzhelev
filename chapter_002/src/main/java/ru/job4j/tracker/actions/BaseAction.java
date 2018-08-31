package ru.job4j.tracker.actions;

import ru.job4j.tracker.start.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 31.08.2018
 */

/**
 * Абстрактный класс, реализующий повторяющиеся методы пунктов меню.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Поле с номером пункта меню (ключем).
     */
    private final int key;
    /**
     * Поле с названием пункта меню.
     */
    private final String name;
	
    /**
     * Конструктор принимает и инициализирует поля.
     * @param key номер пункта меню.
     * @param name название пункта меню.
     */
    public BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Метод возвращает номер пункта меню.
     * @return номер пункта меню.
     */
    public int key() {
        return this.key;
    }

    /**
     * Метод возвращает информацию о пункте меню.
     * @return строка, состоящая из номера и названия пункта меню.
     */
    public String info() {
        return String.format("%d. %s", this.key(), this.name);
    }
}
