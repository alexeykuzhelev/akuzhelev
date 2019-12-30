package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 30.12.2019
 */

/**
 * Класс тестирует функционал для класса DynamicArrayList.
 */
public class DynamicArrayListTest {

    private DynamicArrayList<Integer> dynamicArrayList;

    @Before
    public void beforeTest() {
        dynamicArrayList = new DynamicArrayList<>();
        dynamicArrayList.add(1);
        dynamicArrayList.add(2);
        dynamicArrayList.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(dynamicArrayList.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUsingIteratorResultThree() {
        Iterator<Integer> iterator = dynamicArrayList.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(3));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenUsingIteratorModifyTheCollectionShouldReturnException() {
        Iterator<Integer> iterator = dynamicArrayList.iterator();
        iterator.next();
        iterator.next();
        dynamicArrayList.add(4);
        iterator.next();
    }
}
