package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 27.04.2020
 */

/**
 * Класс реализует собственную структуру данных - HashMap на базе хэш-таблицы.
 * @param <K, V> - типы данных элементов массива.
 */
public class SimpleHashMap<K, V> implements Iterable<V> {
    /**
     * Размер массива текущий.
     */
    private int size = 0;
    /**
     * Внутреннее хранилище данных в виде массива.
     */
    private Node<K, V>[] hashTable;

    public SimpleHashMap() {
        hashTable = (Node<K, V>[]) new Node[16];
    }

    /**
     * Метод определяет хэш ключа.
     */
    private static int hash(Object key) {
        int h;
        if (key == null) {
            h = 0;
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        return h;
    }

    /**
     * Метод вставляет в Map значение по ключу.
     * По одинаковым ключам значение перезаписвается.
     * @param key - ключ.
     * @param value - значение.
     * @return - true, если в ячейке null, или ключи одинаковые.
     * @return - false, если ключи разные, но имеют одинаковый хэш (коллизии не разрешаются).
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        if (size >= hashTable.length) {
            resize(size * 2);
        }
        int hash = hash(key);
        int index = getIndex(hash);
        Node<K, V> oldNode = hashTable[index];
        if (oldNode == null) {
            hashTable[index] = new Node<>(key, value);
            result = true;
            size++;
        } else if (oldNode.key.equals(key)) {
            hashTable[index] = new Node<>(key, value);
            result = true;
        }
        return result;
    }

    /**
     * Метод увеличивает размер массива
     * @param size новый размер массива
     */
    private void resize(int size) {
        Node<K, V>[] firstHashTable = hashTable;
        hashTable = (Node<K, V>[]) new Node[size];
        for (Node<K, V> node : firstHashTable) {
            if (node != null) {
                K key = node.key;
                V value = node.value;
                int hash = hash(key);
                int index = getIndex(hash);
                hashTable[index] = new Node<>(key, value);
            }
        }
    }

    /**
     * Метод получает из Map значение по ключу.
     * @param key - ключ.
     * @return - значение.
     */
    public V get(K key) {
        int hash = hash(key);
        int index = getIndex(hash);
        V value = null;
        Node<K, V> node = hashTable[index];
        if (node != null) {
            if ((node.key == null && key == null)
                    || (node.key != null && node.key.equals(key))) {
                value = node.value;
            }
        }
        return value;
    }

    /**
     * Метод удаляет значение из Map по ключу.
     * @param key - ключ.
     * @return  - true, если в Map был переданный ключ и false, если ключа не было.
     */
    public boolean delete(K key) {
        boolean result = false;
        if (hashTable.length > 0) {
            int hash = hash(key);
            int index = getIndex(hash);
            Node<K, V> node = hashTable[index];
            if (node != null && key.equals(node.key)) {
                hashTable[index] = null;
                result = true;
                size--;
            }
        }
        return result;
    }

    /**
     * Метод получает индекс в массиве по хэшу ключа.
     * @param hash хеш ключа
     * @return индекс в масссиве
     */
    private int getIndex(int hash) {
        return hash & (hashTable.length - 1);
    }

    /**
     * Метод возвращает итератор, предназначенный для обхода массива.
     */
    @Override
    public Iterator<V> iterator() {
        return new SimpleMapIterator();
    }

    /**
     * Класс реализует итератор для обхода массива.
     */
    private class SimpleMapIterator implements Iterator<V> {
        /**
         * Индекс курсора итератора.
         */
        private int index = 0;

        Node<K, V> node = null;

        @Override
        public boolean hasNext() {
            boolean hasNext = false;
            if (index < hashTable.length) {
                do {
                    node = hashTable[index++];
                } while (node == null && index < hashTable.length);
                hasNext = (node != null);
                index--;
            }
            return hasNext;
        }

        /**
         * Получить значение следующего элемента.
         */
        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Simple map");
            }
            return hashTable[index++].value;
        }
    }

    /**
     * Класс для хранения объектов пар "ключ-значение".
     */
    private static class Node<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
