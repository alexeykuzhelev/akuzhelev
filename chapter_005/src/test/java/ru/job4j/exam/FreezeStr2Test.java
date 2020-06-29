package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.06.2020
 */

/**
 * Тестирование двух строк на идентичность.
 */
public class FreezeStr2Test {

    @Test
    public void whenEq() {
        assertThat(FreezeStr2.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr2.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr2.eq("heloo", "hello"), is(false));
    }
}
