package ru.job4j.set;

import ru.job4j.list.DynamicArrayList;

import java.util.Iterator;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 27.02.2020
 */

/**
 * Класс реализует коллекцию Set на массиве.
 * @param <E> - тип данных в коллекции.
 */
public class SimpleSet<E> implements Iterable<E> {

    /**
     * Внутреннее хранилище данных.
     */
    private DynamicArrayList<E> dynamicContainer = new DynamicArrayList<>();

    /**
     * Метод добавляет элемент в коллекцию без дубликатов.
     * @param e - добавляемый элемент.
     */
    public void add(E e) {
        if (contains(e)) {
            dynamicContainer.add(e);
        }
    }

    /**
     * Метод определяет, содержит ли коллекция дубликат элемента.
     */
    public boolean contains(E e) {
        boolean unique = true;
        Iterator itr = iterator();
        while (itr.hasNext()) {
            E element = (E) itr.next();
            if (element.equals(e)) {
                unique = false;
                break;
            }
        }
        return unique;
    }

    @Override
    public Iterator<E> iterator() {
        return dynamicContainer.iterator();
    }
}
