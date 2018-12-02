package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 02.12.2018
 */

/**
 * Класс, реализующий очередь с приоритетами.
 */
public class PriorityQueue {
    /**
     * Массив задач в виде связанного списка.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позицию определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        while (index < tasks.size()) {
            if (task.getPriority() < tasks.get(index).getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    /**
     * Метод возвращает задачу с более высоким приоритетом и удаляет ее из очереди задач.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
