package ru.job4j.profession;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.05.2018
 */

/**
 * Class Patient. Описывает пациента.
 */
public class Patient {
    private String name; //поле содержит имя пациента

    public void setName(String name) {//метод инициалицирует поле имя
        this.name = name;
    }

    public String getName() {//метод возвращает имя пациента
        return name;
    }
}
