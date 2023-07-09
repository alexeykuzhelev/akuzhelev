package ru.job4j.profession;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.05.2018
 */

/**
 * Class House. Описывает дом.
 */
public class House {
    private String adress; /*поле содержит адрес дома*/

    /**
     * Метод  инициалицирует поле адрес.
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Метод  возвращает адрес дома.
     */
    public String getAdress() {
        return adress;
    }
}

