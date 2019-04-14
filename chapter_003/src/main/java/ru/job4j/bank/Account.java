package ru.job4j.bank;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.04.2019
 */

/**
 * Банковский счет.
 */
public class Account {
    /**
     * Количество денег на счете.
     */
    private double value;

    /**
     * Реквизиты счета.
     */
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
