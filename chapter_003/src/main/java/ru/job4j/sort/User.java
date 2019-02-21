package ru.job4j.sort;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 22.02.2019
 */

/**
 * Класс User содержит поля и методы пользователя.
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * Метод сравнивает текущий объект с объектом, переданным в качестве параметра.
     * @param o - другой пользователь для сравнения с текущим.
     * @return   0 если возрасты пользователей равны,
     *          +1 если возраст текущего пользователя больше,
     *          -1 если возраст текущего пользователя меньше.
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return String.format("%s возраст:%s", name, age);
    }
}
