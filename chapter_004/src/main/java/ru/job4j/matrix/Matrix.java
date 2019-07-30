package ru.job4j.matrix;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 30.07.2019
 */

/**
 * Класс реализует преобразование матрицы чисел в список чисел с помощью Stream API.
 */
public class Matrix {
    /**
     * Метод преобразует двумерный массив чисел (матрицу) в список.
     * @param matrixNumbers - двумерный массив чисел (матрица).
     * @return список чисел.
     */
    public List<Integer> getListOfNumbers(Integer[][] matrixNumbers) {
        return Stream.of(matrixNumbers).flatMap(Stream::of).collect(Collectors.toList());
    }
}
