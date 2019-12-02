package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 03.12.2019
 */

/**
 * Класс тестирует универсальную обертку над массивом.
 */
public class SimpleArrayTest {

    @Test
    public void whenAddElementsInContainerShouldGetSameElements() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("test");
        String result = simpleArray.get(0);
        assertThat(result, is("test"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementInFullContainerShouldReturnException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("test1");
        simpleArray.add("test2");
    }

    @Test
    public void whenAddAndSetElementInContainerShouldGetSetElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("test1");
        simpleArray.set(0, "test2");
        String result = simpleArray.get(0);
        assertThat(result, is("test2"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenSetWithoutAddElementsShouldReturnException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.set(0, "test");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenRemoveWithoutAddElementsShouldReturnException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.remove(0);
    }

    @Test
    public void whenAddAndRemove1ElementInContainerShouldGetNull() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("test");
        simpleArray.remove(0);
        assertNull(simpleArray.get(0));
    }

    @Test
    public void whenAdd3AndRemoveMiddleElementInContainerShouldGetLastElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(4);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is("test3"));
    }

    @Test
    public void whenAdd2ElementsInContainerShouldGet2ElementsUsingIterator() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("test1");
        simpleArray.add("test2");
        String[] expected = new String[]{"test1", "test2"};
        String[] result = new String[2];
        Iterator<String> iterator = simpleArray.iterator();
        result[0] = iterator.next();
        result[1] = iterator.next();
        assertThat(result, is(expected));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUsingIteratorNoNextElementShouldReturnException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("test1");
        Iterator<String> iterator = simpleArray.iterator();
        iterator.next();
        iterator.next();
    }
}
