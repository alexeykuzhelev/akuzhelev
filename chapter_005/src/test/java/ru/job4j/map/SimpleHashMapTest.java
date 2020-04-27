package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 27.04.2020
 */

/**
 * Класс тестирует функционал для класса SimpleHashMap.
 */
public class SimpleHashMapTest {

    private SimpleHashMap<String, Integer> simpleHashMap;

    @Before
    public void beforeTest() {
        simpleHashMap = new SimpleHashMap<>();
    }

    @Test
    public void whenInsertValueByKeyShouldGetSameValue() {
        simpleHashMap.insert("key_1", 111);
        assertThat(simpleHashMap.get("key_1"), is(111));
    }

    @Test
    public void whenInsertOneKeyTwiceShouldGetLastValue() {
        simpleHashMap.insert("key_1", 111);
        assertTrue(simpleHashMap.insert("key_1", 222));
        assertThat(simpleHashMap.get("key_1"), is(222));
    }

    @Test
    public void whenGetByNonexistentKeyShouldGetNull() {
        assertNull(simpleHashMap.get("key_1"));
    }

    @Test
    public void whenAddMoreThan16ValuesShouldIncreaseTableSize() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        for (int i = 0; i < 16; i++) {
            simpleHashMap.insert(i, Integer.toString(i));
        }
        assertTrue(simpleHashMap.insert(17, "17"));
        assertThat(simpleHashMap.get(17), is("17"));
    }

    @Test
    public void whenDeleteValueShouldGetNullByKey() {
        assertTrue(simpleHashMap.insert("key_1", 2));
        assertThat(simpleHashMap.get("key_1"), is(2));
        assertTrue(simpleHashMap.delete("key_1"));
        assertNull(simpleHashMap.get("key_1"));
    }

    @Test
    public void whenDeleteNonexistentKeyShouldGetFalse() {
        assertFalse(simpleHashMap.delete("key_1"));
    }

    @Test
    public void whenUsingIteratorShouldReturnAllValues() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(000, "000");
        simpleHashMap.insert(001, "111");
        Iterator<String> iterator = simpleHashMap.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("000"));
        assertThat(iterator.next(), is("111"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextThreeShouldGetException() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(000, "000");
        simpleHashMap.insert(001, "111");
        Iterator<String> iterator = simpleHashMap.iterator();
        assertThat(iterator.next(), is("000"));
        assertThat(iterator.next(), is("111"));
        iterator.next();
    }
}
