package ru.job4j.list;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 16.02.2020
 */

/**
 * Класс проверяет зацикленность элементов связанного списка.
 * @param <T> - параметризуемый тип элемента связанного списка.
 */
public class Node<T> {
    /**
     * Данные, хранимые в элементе списка.
     */
    T value;
    /**
     * Сcылка на следующий элемент списка.
     */
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    /**
     * Метод реализует алгоритм, определяющий, что список содержит замыкания.
     * @param first - первый узел списка.
     * @return - true, если список содержит замыкания и false, если не содержит.
     */
    boolean hasCycle(Node<T> first) {
        Node<T> before = first;
        Node<T> fore = first.next;
        boolean result = false;
        while (fore != null && fore.next != null) {
            if (before == fore) {
                result = true;
                break;
            }
            before = before.next;
            fore = fore.next.next;
        }
        return result;
    }
}
