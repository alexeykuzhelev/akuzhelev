package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 10.06.2019
 */

public class DiapasonTest {
    /**
     * Тест проверяет подсчет линейной функции.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Тест проверяет подсчет квадратичной функции.
     */	
    @Test
    public void whenQuadraticFunctionThenQuadtraticResults() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 3 * x + 4);
        List<Double> expected = Arrays.asList(69D, 94D, 123D);
        assertThat(result, is(expected));
    }

    /**
     * Тест проверяет подсчет логарифмической функции.
     */	
    @Test
    public void whenLogarithmFunctionThenLogarithmResults() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(5, 8, Math::log);
        List<Double> expected = Arrays.asList(1.6094379124341003D, 1.791759469228055D, 1.9459101490553133D);
        assertThat(result, is(expected));
    }
}
