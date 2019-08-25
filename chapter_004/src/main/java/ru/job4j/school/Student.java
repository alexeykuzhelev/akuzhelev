package ru.job4j.school;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 25.08.2019
 */

/**
 * Класс реализует поля и методы ученика.
 */
public class Student implements Comparator<Student> {
    /**
     * Общий балл ученика по всем предметам.
     */
    private int score;
    /**
     * Фамилия ученика.
     */
    private String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student("
                + "score = " + score + ", " + "surname = " + surname + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public int compare(Student s1, Student s2) {
        return s2.getScore() - s1.getScore();
    }
}
