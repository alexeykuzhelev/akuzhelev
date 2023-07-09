package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 23.03.2018
 */

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        /*тест, проверяющий заполняемость массива из трех элементов числами возведенными в квадрат*/
        int bound = 3;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBound3Then149162536() {
        /*тест, проверяющий заполняемость массива из шести элементов числами возведенными в квадрат*/
        int bound = 6;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25, 36};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBound3Then14() {
        /*тест, проверяющий заполняемость массива из двух элементов числами возведенными в квадрат*/
        int bound = 2;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1, 4};
        assertThat(result, is(expect));
    }
}
