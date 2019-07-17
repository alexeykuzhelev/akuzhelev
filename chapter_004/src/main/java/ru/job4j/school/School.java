package ru.job4j.school;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 17.07.2019
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

    /**
     * Метод преобразует список учеников в Map.
     * @param students - список учеников.
     * @return Map, где ключ - фамилия ученика, а значение - объект ученика.
     */
    public Map<String, Student> getMapStudents(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(student -> student.getSurname(), student -> student));
    }

    public static void main(String[] args) {
        School school = new School();
        Student student1 = new Student(15, "Petrov");
        Student student2 = new Student(70, "Ivanov");
        Student student3 = new Student(70, "Ivanov");
        List<Student> students = Arrays.asList(student1, student2, student3);
        Map<String, Student> mapStudents = school.getMapStudents(students);
        mapStudents.entrySet().stream().forEach((entry) -> {
            String result = "Key: " + entry.getKey() + ", " + "Value: " + entry.getValue().toString();
            System.out.println(result);
        });
    }
}
