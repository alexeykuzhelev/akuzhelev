package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 03.12.2019
 */

/**
 * Класс реализует универсальную обертку над массивом.
 */
public class SimpleArray<T> implements Iterable<T> {

    private final Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Метод добавляет указанный элемент (model) в первую свободную ячейку.
     */
    public void add(T model) throws ArrayIndexOutOfBoundsException {
        this.objects[index++] = model;
    }

    /**
     * Метод заменяет указанным элементом (model) элемент, находящийся по индексу position.
     */
    public void set(int position, T model) throws ArrayIndexOutOfBoundsException {
        checkSizeContainer(position);
        this.objects[position] = model;
    }

    /**
     * Метод удаляет элемент по указанному индексу.
     * Все находящиеся справа элементы при этом необходимо сдвинуть на единицу влево.
     */
    public void remove(int position) throws ArrayIndexOutOfBoundsException {
        checkSizeContainer(position);
        System.arraycopy(this.objects, position + 1, this.objects,
                position, index - position);
        this.objects[index] = null;
        index--;
    }

    /**
     * Метод возвращает элемент, расположенный по указанному индексу.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }

    /**
     * Метод возвращает итератор, предназначенный для обхода данной структуры.
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator(index,
                (Iterator<T>) Arrays.asList(this.objects).iterator());
    }

    /**
     * Метод выкидывает исключение, если индекс выходит за границу массива.
     */
    private void checkSizeContainer(int position) throws ArrayIndexOutOfBoundsException {
        if (position > index || index == 0) {
            throw new ArrayIndexOutOfBoundsException("container empty or full");
        }
    }

    /**
     * Класс реализует итератор для массива.
     */
    private class SimpleArrayIterator implements Iterator<T> {

        private final int size;
        private int index = 0;
        private final Iterator<T> arrayIterator;

        public SimpleArrayIterator(int size, Iterator<T> arrayIterator) {
            this.size = size;
            this.arrayIterator = arrayIterator;
        }

        @Override
        public boolean hasNext() {
            return (index <= size - 1) && arrayIterator.hasNext();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("no any next element");
            }
            index++;
            return arrayIterator.next();
        }
    }
}
