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
    private String adress; //поле содержит адрес дома

    public void setAdress(String adress) {//метод инициалицирует поле адрес
        this.adress = adress;
    }

    public String getAdress() {//метод возвращает адрес дома
        return adress;
    }
}

