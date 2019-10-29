package ru.job4j.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 25.08.2019
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
        return students.stream().
                collect(Collectors.toMap(student -> student.getSurname(),
                        student -> student,
                        (s, s1) -> {
                            System.out.println("Дубликат: " + s1);
                            return s;
                        }
                ));
    }

    /**
     * Метод отбирает студентов, у которых балл аттестата больше заданного значения.
     * Кроме того убирает значения null в списке студентов с помощью метода Stream.ofNullable.
     * @param students - список студентов.
     * @param bound - балл аттестата студента должен быть выше этого значения.
     * @return список студентов, отфильтрованных в соответствии с условием.
     */
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted((s1, s2) -> s1.compare(s1, s2))
                .takeWhile(x -> x.getScore() > bound).collect(Collectors.toList());
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
        int bound = 50;
        List<Student> arrayStudents = new ArrayList<>(students);
        arrayStudents.add(null);
        List<Student> result2 = school.levelOf(arrayStudents, bound);
        System.out.println(result2);
    }
}
