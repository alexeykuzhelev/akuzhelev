package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 09.02.2020
 */

/**
 * Класс создает динамический контейнер на базе связанного списка.
 * @param <E> - тип данных в контейнере.
 */
public class DynamicLinkedListStackContainer<E> implements Iterable<E> {
    /**
     * Сcылка на первый элемент списка.
     */
    private Node<E> first;
    /**
     * Сcылка на последний элемент списка.
     */
    private Node<E> last;
    /**
     * Счетчик изменений - для  fail-fast поведения итератора.
     */
    private int modCount = 0;
    /**
     * Размер списка текущий.
     */
    private int size;

    /**
     * Метод вставляет элемент в конец связанного списка.
     * @param value - данные, хранимые в элементе списка.
     */
    public void add(E value) {
        Node<E> newElement = new Node<>(value);
        if (first == null) {
            first = newElement;
        } else {
            last = first;
            while (last.next != null) {
                last = last.next;
            }
            newElement.prev = last;
            last.next = newElement;
        }
        size++;
        modCount++;
    }

    /**
     * Метод вставляет в начало очереди новый элемент.
     */
    public void addFirst(E value) {
        Node<E> newElement = new Node<>(value);
        if (size > 0) {
            first.prev = newElement;
        }
        newElement.next = first;
        first = newElement;
        if (size <= 0) {
            last = newElement;
        }
        size++;
        modCount++;
    }

    /**
     * Метод удаляет элемент из конца очереди по FIFO и возвращает его значение.
     * @return - значение удаляемого элемента.
     */
    public E deleteFirst() {
        E deletedData = null;
        if (size != 0) {
            deletedData = last.data;
            last = last.prev;
        }
        size--;
        modCount++;
        return deletedData;
    }

    /**
     * Метод удаляет последний элемент в списке и возвращает его значение.
     * @return - значение удаляемого элемента.
     */
    public E deleteLast() {
        E deletedData = null;
        last = first;
        if (last != null) {
            while (last.next != null) {
                last = last.next;
            }
            deletedData = unlink(last);
        }
        return deletedData;
    }

    /**
     * Метод связывает элементы при удалении.
     * Убирает ссылки на последний элемент.
     * Делает предыдущий элемент последним.
     * @param node - последний элемент в списке.
     * @return - значение удаляемого элемента.
     */
    private E unlink(Node<E> node) {
        E deletedData = node.data;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev != null) {
            prev.next = null;
            last = prev;
        } else {
            first = null;
            last = null;
        }
        size--;
        modCount++;
        return deletedData;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Iterator<E> iterator = iterator();
        E result = null;
        for (int i = 0; i <= index; i++) {
            result = iterator.next();
        }
        return result;
    }

    /**
     * Метод возвращает итератор, предназначенный для обхода связанного списка.
     * @return - итератор с типом возвращаемого значения <E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new DynamicLinkedListStackContainer.DynamicLinkedIterator();
    }

    /**
     * Класс реализует итератор с проверкой модификации связанного списка при обходе.
     */
    private class DynamicLinkedIterator implements Iterator<E> {
        /**
         * Текущая позиция итератора.
         */
        private Node<E> cursor = first;
        /**
         * Значение счетчика на момент создания итератора.
         */
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            E result = cursor.data;
            cursor = cursor.next;
            return result;
        }
    }

    /**
     * Класс для хранения данных связанного списка.
     * @param <E> - данные, хранимые в элементе списка.
     */
    private static class Node<E> {
        /**
         * Данные, хранимые в элементе списка.
         */
        private E data;
        /**
         * Сcылка на предыдущий элемент списка.
         */
        private Node<E> prev;
        /**
         * Сcылка на следующий элемент списка.
         */
        private Node<E> next;

        private Node(E data) {
            this.data = data;
        }
    }

    /**
     * Метод возвращает размер списка.
     * @return - размер списка.
     */
    public int size() {
        return size;
    }
}
