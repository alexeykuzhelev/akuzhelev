package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 03.06.2020
 */

/**
 * Класс реализует элементарную структуру дерева.
 * @param <E> - тип значения, хранящегося в узле дерева.
 */
public class Tree<E> implements SimpleTree<E> {
    /**
     * Первичный узел дерева.
     */
    private Node<E> root;

    /**
     * Конструктор дерева.
     * @param value - начальное значение, помещаемое в первичный узел.
     */
    public Tree(E value) {
        this.root = new Node<>(value);
    }

    /**
     * Метод находит родительский узел и добавляет в него дочерний узел.
     * Родительский узел может иметь список дочерних узлов.
     * @param parent - родительский узел.
     * @param child - дочерний узел.
     * @return - true, если узел добавлен в дерево.
     * @return - false, если parent и child уже есть в дереве.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (!findBy(child).isPresent()) {
            Optional<Node<E>> parentNode = findBy(parent);
            if (parentNode.isPresent()) {
                parentNode.get().children.add(new Node<>(child));
                result = true;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                result = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return result;
    }

    /**
     * Метод проверяет количество дочерних элементов в дереве.
     * Если дочерних элементов <= 2 - то дерево бинарное.
     * Метод должен циклически пройти по всем элементам дерева.
     * @return - true, если дерево бинарное.
     * @return - false, если дерево не бинарное.
     */
    public boolean isBinary() {
        boolean isBinary = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() > 2) {
                isBinary = false;
                break;
            } else {
                data.addAll(el.children);
            }
        }
        return isBinary;
    }
}
