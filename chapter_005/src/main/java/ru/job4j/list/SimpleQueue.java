package ru.job4j.list;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 09.02.2020
 */

/**
 * Класс реализует очередь на двух стеках. Описывается FIFO - первый зашел и первый вышел.
 * @param <T> - параметризуемый тип элнмента связанного списка.
 */
public class SimpleQueue<T> {
    /**
     * Поле для первого стека.
     */
    private SimpleStackFIFO<T> stackOne = new SimpleStackFIFO<>();
    /**
     * Поле для второго стека.
     */
    private SimpleStackFIFO<T> stackTwo = new SimpleStackFIFO<>();

    /**
     * Метод удаляет элемент из очереди и возвращает его значение по FIFO.
     * @return - значение удаляемого элемента.
     */	
    public T poll() {
        if (stackTwo.size() == 0) {
            int stackSize = stackOne.size();
            for (int i = 0; i < stackSize; i++) {
                stackTwo.push(stackOne.poll());
            }
        }
        return stackTwo.poll();
    }	
	
    /**
     * Метод вставляет элемент в начало очереди, используя первый стек.
     * @param value - данные, хранимые в элементе списка.
     */
    public void push(T value) {
        stackOne.push(value);
    }
}
