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

    public void setName(String name) {//метод инициалицирует поле имя
        this.name = name;
    }

    public String getName() {//метод возвращает имя студента
        return name;
    }
}
