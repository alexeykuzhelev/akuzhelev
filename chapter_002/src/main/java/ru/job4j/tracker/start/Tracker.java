package ru.job4j.tracker.start;

import ru.job4j.tracker.models.*;
import java.util.Random;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 16.06.2018
 */

/**
 * Class Tracker для работы с заявками
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Поле генерации id.
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка (массив)
     * @return Item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания, для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Метод генерации id.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Поиск заявки по id.
     * Метод проверяет в цикле все элементы массива this.items, сравнивая id с аргументом String id и возвращает  
     * найденный Item.
     * Если Item не найден - возвращает null.
     * @param id заявки
     * @return Item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод replace должен заменить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id.
     * @param id заявки   
     * @param item
     */
    public void replace(String id, Item item) {
        for (int i = 0; i != this.position; i++) {
            if (findById(id).equals(items[i])) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Метод delete должен удалить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id.
     * Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с помощью
     * System.arrayCopy().
     * @param id заявки 
     */
    public void delete(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = null;
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                items[items.length - 1] = null;
                break;
            }
        }
    }

    /**
     * Метод  findAll() возвращает копию массива this.items без null элементов.
     * @return Item[]
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     * @param key;
     * @return Item[]
     */
    public Item[] findByName(String key) {
        int index = 0;
        Item[] tmp = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(key)) {
                tmp[index++] = items[i];
            }
        }
        Item[] result = new Item[index];
        System.arraycopy(tmp, 0, result, 0, index);
        return result;
    }
}
