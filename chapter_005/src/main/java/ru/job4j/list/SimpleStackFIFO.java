package ru.job4j.list;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 09.02.2020
 */

/**
 * Класс, реализующий стек. Описывается FIFO - первый зашел и первый вышел.
 * @param <T> - параметризуемый тип элнмента связанного списка.
 */
public class SimpleStackFIFO<T> {
    /**
     * Динамический контейнер на базе связанного списка.
     */
    private DynamicLinkedListStackContainer<T> stackContainer = new DynamicLinkedListStackContainer<>();

    /**
     * Метод удаляет элемент из конца связанного списка и возвращает его значение.
     * @return - значение удаляемого элемента.
     */
    public T poll() {
        return stackContainer.deleteFirst();
    }

    /**
     * Метод вставляет элемент в начало связанного списка.
     * @param value - данные, хранимые в элементе списка.
     */
    public void push(T value) {
        stackContainer.addFirst(value);
    }

    /**
     * Метод возвращает размер списка.
     * @return - размер списка.
     */
    public int size() {
        return stackContainer.size();
    }
}
