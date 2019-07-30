package ru.job4j.matrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 30.07.2019
 */

/**
 * Класс проверяет преобразование матрицы чисел в список чисел с помощью Stream API.
 */
public class MatrixTest {
    /**
     * Тест проверяет преобразование матрицы чисел в список чисел.
     */
    @Test
    public void whenMatrixOfNumbersTransformToListOfNumbers() {
        Matrix matrix = new Matrix();
        Integer[][] matrixNumbers = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = matrix.getListOfNumbers(matrixNumbers);
        assertThat(expected, is(result));
    }
}
