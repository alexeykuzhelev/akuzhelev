package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 16.02.2020
 */

/**
 * Класс тестирует зацикленность элементов связанного списка.
 */
public class NodeTest {

    /**
     * Тест проверяет незацикленный список на наличие зацикленностей.
     */
    @Test
    public void whenHasNoCycleShouldFalse() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        assertFalse(first.hasCycle(first));
    }

    /**
     * Тест проверяет зацикленный список на наличие зацикленностей.
     * Список зациклен с последнего элемента на первый.
     */
    @Test
    public void whenHasCycleFromLastToFirstShouldTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(first.hasCycle(first));
    }

    /**
     * Тест проверяет зацикленный список на наличие зацикленностей.
     * Список зациклен с третьего элемента на второй.
     */
    @Test
    public void whenHasCycleFromThirdToTwoShouldTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = first;
        assertTrue(first.hasCycle(first));
    }
}
