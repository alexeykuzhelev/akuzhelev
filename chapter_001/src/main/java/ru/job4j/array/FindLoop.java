package ru.job4j.array;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 26.03.2018
 */

public class FindLoop {
    /**
     * Поиск индекса элемента в массиве, удовлетворяющий условию.
     * Метод должен вернуть индекс элемента.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            //если элемент найден, то останавливаем цикл и возвращаем индекс
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
