package ru.job4j.fit;

/**
 * Программа расчета идеального веса.
 */
public class Fit {
    private static final int HUNDRED = 100;
    private static final int HUNDRED_TEN = 110;
    private static final double COEF = 1.15;
    private double result;

    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double manWeight(double height) {
        result = (height - HUNDRED) * COEF;
        return this.result;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double womanWeight(double height) {
        result = (height - HUNDRED_TEN) * COEF;
        return this.result;
    }
}