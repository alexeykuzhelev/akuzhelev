package ru.job4j.list;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 04.02.2020
 */

/**
 * Класс реализует очередь на двух стеках. Описывается FIFO - первый зашел и первый вышел.
 * @param <T> - параметризуемый тип элнмента связанного списка.
 */
public class SimpleQueue<T> {
    /**
     * Динамический контейнер на базе связанного списка.
     */
    private DynamicLinkedListStackContainer<T> stackContainer = new DynamicLinkedListStackContainer<>();

    /**
     * Метод удаляет первый элемент из очереди и возвращает его значение.
     * @return - значение удаляемого элемента.
     */
    public T poll() {
        return stackContainer.deleteFirst();
    }

    /**
     * Метод вставляет элемент в конец связанного списка.
     * @param value - данные, хранимые в элементе списка.
     */
    public void push(T value) {
        stackContainer.add(value);
    }
}
