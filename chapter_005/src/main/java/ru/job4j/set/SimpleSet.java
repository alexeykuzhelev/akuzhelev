package ru.job4j.set;

import ru.job4j.list.DynamicArrayList;

import java.util.Iterator;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 23.02.2020
 */

/**
 * Класс реализует коллекцию Set на массиве.
 * @param <E> - тип данных в коллекции.
 */
public class SimpleSet<E> extends DynamicArrayList<E> {
    /**
     * Конструктор вызывает конструктор суперкласса.
     */
    public SimpleSet() {
        super();
    }

    /**
     * Метод добавляет элемент в коллекцию без дубликатов.
     * @param e - добавляемый элемент.
     */
    @Override
    public void add(E e) {
        boolean unique = true;
        Iterator itr = super.iterator();
        while (itr.hasNext()) {
            E element = (E) itr.next();
            if (element.equals(e)) {
                unique = false;
                break;
            }
        }
        if (unique) {
            super.add(e);
        }
    }
}
