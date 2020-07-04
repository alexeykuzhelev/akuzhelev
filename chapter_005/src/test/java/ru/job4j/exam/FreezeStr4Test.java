package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 04.07.2020
 */

/**
 * Тестирование двух строк на идентичность.
 */
public class FreezeStr4Test {

    @Test
    public void whenEq() {
        assertThat(FreezeStr4.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr4.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr4.eq("heloo", "hello"), is(false));
    }
}
