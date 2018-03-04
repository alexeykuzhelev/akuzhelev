package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMoreSecond() {
        Max maxim = new Max();
        int result = maxim.max(5, 3);
        assertThat(result, is(5));
    }

    @Test
    public void whenFirstMoreSecondAndThird() {
        Max maximum = new Max();
        int result = maximum.max(5, 3, 2);
        assertThat(result, is(5));
    }

    @Test
    public void whenFirstAndSecondLessThird() {
        Max maximum = new Max();
        int result = maximum.max(1, 2, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstAndThirdLessSecond() {
        Max maximum = new Max();
        int result = maximum.max(2, 5, 3);
        assertThat(result, is(5));
    }
}