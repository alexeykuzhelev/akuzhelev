package ru.job4j.school;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 04.07.2019
 */

/**
 * Класс реализует фильтрацию учеников по диапазону баллов с помощью Stream API.
 */
public class School {
    /**
     * Метод реализует фильтрацию учеников по диапазону баллов.
     * @param students - список студентов для фильтрации.
     * @param predicate - лямбда выражение реализующее условие фильтрации учеников.
     * @return список студентов, отфильтрованных в соответствии с условием.
     **/
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }
}
