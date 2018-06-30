package ru.job4j.profession;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.05.2018
 */

/**
 * Class Student. Описывает студента.
 */
public class Student {
    private String name; //поле содержит имя студента

    /**
     * Метод  инициалицирует поле имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод  возвращает имя студента.
     */
    public String getName() {
        return name;
    }
}
