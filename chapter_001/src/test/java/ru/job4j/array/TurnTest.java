package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.03.2018
 */

public class TurnTest {
    @Test
    public void WhenArrayHasOddLength() {
        //тест, проверяющий переворот массива с нечётным числом элементов.
        Turn turner = new Turn();
        int[] input = {1, 2, 3, 4, 5};
        int[] result = turner.back(input);
        int[] expect = {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void WhenArrayHasEvenLength() {
        //тест, проверяющий переворот массива с чётным числом элементов.
        Turn turner = new Turn();
        int[] input = {4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = {2, 6, 1, 4};
        assertThat(result, is(expect));
    }
}
