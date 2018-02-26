package ru.job4j.max;

/**
 * Определить, какое из двух чисел больше.
 */
public class Max {
    // если first > second, то возвращает first, иначе возврашает second.
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
}