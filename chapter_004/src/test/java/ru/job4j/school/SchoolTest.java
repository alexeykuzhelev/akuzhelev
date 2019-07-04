package ru.job4j.school;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 04.07.2019
 */

/**
 * Класс получения списка учеников для классов: А, B, C.
 */
public class SchoolTest {

    private School school = new School();
    private Student student1 = new Student(15);
    private Student student2 = new Student(65);
    private Student student3 = new Student(90);
    private List<Student> students = Arrays.asList(student1, student2, student3);
    /**
     * Тест проверяет попадание ученика в диапазон баллов от 70 до 100 (класс A).
     */
    @Test
    public void whenStudentScoreToDiapason70And100() {
        List<Student> expect = Arrays.asList(new Student(90));
        List<Student> result = school.collect(students, (x) -> x.getScore() > 70 && x.getScore() <= 100);
        assertThat(result, is(expect));
    }
    /**
     * Тест проверяет попадание ученика в диапазон баллов от 50 до 70 (класс B).
     */
    @Test
    public void whenStudentScoreToDiapason50And70() {
        List<Student> expect = Arrays.asList(new Student(65));
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
}
