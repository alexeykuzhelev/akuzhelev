package ru.job4j.generic;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 15.12.2019
 */

/**
 * Абстрактный класс для моделей c методами String getId().
 */
public abstract class Base {

    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Метод возвращает id модели, добавляемой в массив.
     */
    public String getId() {
        return this.id;
    }
}
