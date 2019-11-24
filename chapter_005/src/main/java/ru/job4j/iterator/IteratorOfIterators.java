package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 24.11.2019
 */

/**
 * Класс реализует итератор чисел из итератора итераторов.
 */
public class IteratorOfIterators implements Iterator<Integer> {

    private Iterator<Iterator<Integer>> it;
    private Iterator<Integer> numbersIterator;

    public IteratorOfIterators() {
    }

    public IteratorOfIterators(Iterator<Iterator<Integer>> it) {
        this.it = it;
        this.numbersIterator = it.hasNext() ? it.next() : null;
    }


    /**
     * Метод принимает объект итератор итераторов и возвращает объект итератора чисел.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new IteratorOfIterators(it);
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        if (numbersIterator != null) {
            hasNext = numbersIterator.hasNext();
            while (!hasNext && it.hasNext()) {
                numbersIterator = it.next();
                hasNext = numbersIterator.hasNext();
            }
        }
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("no any iterators");
        }
        if (!numbersIterator.hasNext()) {
            numbersIterator = it.next();
        }
        return numbersIterator.next();
    }
}
