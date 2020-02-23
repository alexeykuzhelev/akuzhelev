package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 23.02.2020
 */

/**
 * Класс тестирует добавление элементов в коллекцию без дубликатов.
 */
public class SimpleSetTest {

    private SimpleSet<Integer> simpleSet;

    @Before
    public void beforeTest() {
        simpleSet = new SimpleSet<>();
    }

    @Test
    public void whenAddDuplicatesThenUsingIteratorResultNoDuplicates() {
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(2);
        Iterator<Integer> iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }
}
