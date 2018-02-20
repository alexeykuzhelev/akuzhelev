package ru.job4j.fit;

/**
 * Программа расчета идеального веса.
 */
public class Fit {
    private double result;

    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double manWeight(double height) {
        result = (height - 100) * 1.15;
		return this.result;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double womanWeight(double height) {
        result = (height - 110) * 1.15;
		return this.result;
    }
}