package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 10.01.2020
 */

/**
 * Класс тестирует функционал для класса DynamicLinkedList.
 */
public class DynamicLinkedListTest {

    private DynamicLinkedList<Integer> dynamicLinkedList;

    @Before
    public void beforeTest() {
        dynamicLinkedList = new DynamicLinkedList<>();
        dynamicLinkedList.add(1);
        dynamicLinkedList.add(2);
        dynamicLinkedList.add(3);
    }

    @Test
    public void whenUseGetOneResultTwo() {
        assertThat(dynamicLinkedList.get(1), is(2));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenUseGetThreeShouldReturnException() {
        dynamicLinkedList.get(3);
    }

    @Test
    public void whenUsingIteratorResultThree() {
        Iterator<Integer> iterator = dynamicLinkedList.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(3));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenUsingIteratorModifyTheCollectionShouldReturnException() {
        Iterator<Integer> iterator = dynamicLinkedList.iterator();
        iterator.next();
        iterator.next();
        dynamicLinkedList.add(4);
        iterator.next();
    }

    @Test (expected = NoSuchElementException.class)
    public void whenUsingIteratorNoNextElementShouldReturnException() {
        Iterator<Integer> iterator = dynamicLinkedList.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}
