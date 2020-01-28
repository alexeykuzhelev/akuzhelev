package ru.job4j.list;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 28.01.2020
 */

/**
 * Класс, реализующий стек. Описывается LIFO - последний зашел и первый вышел.
 * @param <T> - параметризуемый тип элнмента связанного списка.
 */
public class SimpleStack<T> {
    /**
     * Динамический контейнер на базе связанного списка.
     */
    private DynamicLinkedListStackContainer<T> stackContainer = new DynamicLinkedListStackContainer<>();

    /**
     * Метод удаляет последний элемент в списке и возвращает его значение.
     * @return - значение удаляемого элемента.
     */
    public T poll() {
        return stackContainer.deleteLast();
    }

    /**
     * Метод вставляет элемент в конец связанного списка.
     * @param value - данные, хранимые в элементе списка.
     */
    public void push(T value) {
        stackContainer.add(value);
    }
}
