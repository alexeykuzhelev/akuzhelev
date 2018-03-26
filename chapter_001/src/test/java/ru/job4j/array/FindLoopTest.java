package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 26.03.2018
 */

public class FindLoopTest {

    @Test
    public void whenArrayHasEl3Then1() {
        //тест, проверяющий, что метод находит элемент со значением 3
        FindLoop find = new FindLoop();
        int[] input = new int[] {7, 3, 5};
        int value = 3;
        int result = find.indexOf(input, value);
        int expect = 1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasEl7ThenMinus1() {
        //тест, проверяющий, что метод не находит элемент в массиве
        FindLoop find = new FindLoop();
        int[] input = new int[] {1, 3, 2, 5, 4};
        int value = 7;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
