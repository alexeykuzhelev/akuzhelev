package ru.job4j.search;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 02.12.2018
 */

/**
 * Класс задач.
 */
public class Task {
    /**
     * Поле описания задачи.
     */
    private String desc;
    /**
     * Поле приоритета задачи.
     */
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
