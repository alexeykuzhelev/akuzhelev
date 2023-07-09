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
    private String name; /*поле содержит имя пациента*/

    /**
     * Метод  инициалицирует поле имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод  возвращает имя пациента.
     */
    public String getName() {
        return name;
    }
}
