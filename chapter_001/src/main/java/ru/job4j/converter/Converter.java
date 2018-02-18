package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {
    private int ruble;
    private int euro;
    private int dollar;
    private int courseEuro = 70;
    private int courseDollar = 60;
    private double result;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return евро.
     */
    public double rubleToEuro(int value) {
        ruble = value;
        result = ruble / courseEuro;
        return this.result;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public double euroToRuble(int value) {
        euro = value;
        result = euro * courseEuro;
        return this.result;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return доллоры
     */
    public double rubleToDollar(int value) {
        ruble = value;
        result = ruble / courseDollar;
        return this.result;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     */
    public double dollarToRuble(int value) {
        dollar = value;
        result = dollar * courseDollar;
        return this.result;
    }

}