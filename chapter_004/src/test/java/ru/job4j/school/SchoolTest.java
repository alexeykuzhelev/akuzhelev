package ru.job4j.school;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 25.08.2019
 */

/**
 * Класс получения списка учеников для классов: А, B, C.
 */
public class SchoolTest {

    private School school = new School();
    private Student student1 = new Student(15, "Petrov");
    private Student student2 = new Student(70, "Ivanov");
    private Student student3 = new Student(70, "Ivanov");
    private List<Student> students = Arrays.asList(student1, student2, student3);
    /**
     * Тест проверяет попадание ученика в диапазон баллов от 70 до 100 (класс A).
     */
    @Test
    public void whenStudentScoreToDiapason70And100() {
        List<Student> expect = Arrays.asList(new Student(70, "Ivanov"),
                new Student(70, "Ivanov"));
        List<Student> result = school.collect(students, (x) -> x.getScore() >= 70 && x.getScore() <= 100);
        assertThat(result, is(expect));
    }
    /**
     * Тест проверяет попадание ученика в диапазон баллов от 50 до 70 (класс B).
     */
    @Test
    public void whenStudentScoreToDiapason50And70() {
        List<Student> expect = Arrays.asList(new Student(70, "Ivanov"),
                new Student(70, "Ivanov"));
        List<Student> result = school.collect(students, (x) -> x.getScore() > 50 && x.getScore() <= 70);
        assertThat(result, is(expect));
    }
    /**
     * Тест проверяет попадание ученика в диапазон баллов от 0 до 50 (класс C).
     */
    @Test
    public void whenStudentScoreToDiapason0And50() {
        List<Student> expect = Arrays.asList(new Student(15));
        List<Student> result = school.collect(students, (x) -> x.getScore() >= 0 && x.getScore() < 50);
        assertThat(result, is(expect));
    }
    /**
     * Тест проверяет преобразование список учеников в Map.
     */
    @Test
    public void whenListStudentsTransformToMapStudents() {
        Map<String, Student> expect = new HashMap<>();
        expect.put(student1.getSurname(), student1);
        expect.put(student2.getSurname(), student2);
        Map<String, Student> result = school.getMapStudents(students);
        assertThat(result, is(expect));
    }
    /**
     * Тест проверяет отбор студентов, у которых балл аттестата больше заданного значения.
     */
    @Test
    public void whenStudentScoreMoreThenBound() {
        int bound = 50;
        List<Student> expect = Arrays.asList(student3, student2);
        List<Student> arrayStudents = new ArrayList<>(students);
        arrayStudents.add(null);
        List<Student> result = school.levelOf(arrayStudents, bound);
        assertThat(result, is(expect));
    }
}
