package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {
    private static final int COURSE_EURO = 70;
    private static final int COURSE_DOLLAR = 60;
    private double result;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return евро.
     */
    public double rubleToEuro(int value) {
        int ruble = value;
        result = ruble / COURSE_EURO;
        return this.result;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public double euroToRuble(int value) {
        int euro = value;
        result = euro * COURSE_EURO;
        return this.result;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return доллоры
     */
    public double rubleToDollar(int value) {
        int ruble = value;
        result = ruble / COURSE_DOLLAR;
        return this.result;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     */
    public double dollarToRuble(int value) {
        int dollar = value;
        result = dollar * COURSE_DOLLAR;
        return this.result;
    }

}