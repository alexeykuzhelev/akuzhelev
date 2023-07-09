package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 13.04.2018
 */

public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        /*тест проверяет, что слово начинаеться с префикса*/
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startsWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        /*тест проверяет, что слово не начинаеться с префикса*/
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startsWith("Hi");
        assertThat(result, is(false));
    }
}
