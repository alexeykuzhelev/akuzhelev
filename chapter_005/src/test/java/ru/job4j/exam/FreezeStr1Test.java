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
public class FreezeStr1Test {

    @Test
    public void whenEq() {
        assertThat(FreezeStr1.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr1.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr1.eq("heloo", "hello"), is(false));
    }
}
