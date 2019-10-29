package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 30.10.2019
 */

public class StreamApiTest {
    /**
     * Тест проверяет фильтрацию четных чисел и результат вычислений над ними.
     */
    @Test
    public void when4028ThenCalculate84() {
        StreamApi streamApi  = new StreamApi();
        int[] arr = {5, 4, 7, 0, 1, 2, 3, 8};
        assertThat(streamApi.calculate(arr), is(84));
    }
}
