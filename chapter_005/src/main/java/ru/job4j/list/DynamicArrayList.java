package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 02.01.2020
 */

/**
 * Класс создает динамический список на базе массива.
 * @param <T> - тип данных в контейнере.
 */
public class DynamicArrayList<T> implements Iterable<T> {

    private Object[] container;

    /**
     * Размер колелкции по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Счетчик добавляемых элементов колелкции.
     */
    private int counter = 0;

    /**
     * Счетчик изменений - для  fail-fast поведения итератора.
     */
    private int modCount = 0;

    /**
     * Конструктор по умолчанию.
     */
    public DynamicArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Конструктор с заданной емкостью колелкции.
     * @param capacity - емкость колелкции.
     */
    public DynamicArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        container = new Object[capacity];
    }

    /**
     * Метод добавляет объект в коллекцию.
     * При этом он проверяет размер колелкции, и если нужно, увеличивает ее на DEFAULT_CAPACITY.
     * @param value - добавляемый объект.
     */
    public void add(T value) {
        if (counter >= container.length) {
            container = Arrays.copyOf(container, counter + DEFAULT_CAPACITY);
        }
        container[counter++] = value;
        modCount++;
    }

    /**
     * Метод получения элемента из колелкции.
     * @param index - индекс объекта.
     * @return - объект по заданному индексу.
     */
    public T get(int index) {
        if (index >= counter) {
            throw new IndexOutOfBoundsException();
        }
        return (T) container[index];
    }

    /**
     * Метод получает количество добавленных в коллекцию элементов.
     * @return - количество элементов в коллекции.
     */
    public int counter() {
        return counter;
    }

    /**
     * Метод возвращает итератор, предназначенный для обхода коллекции.
     */
    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayList.DynamicArrayIterator();
    }

    /**
     * Класс реализует итератор с проверкой модификации коллекции при обходе.
     */
    private class DynamicArrayIterator implements Iterator<T> {

        private int cursor = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor < counter;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) container[cursor++];
        }
    }
}
