package ru.job4j.tracker.storage;

import ru.job4j.tracker.models.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 27.01.2019
 */

/**
 * Class Tracker для работы с заявками
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

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
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания, для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
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
        item.setId(id);
        for (int i = 0; i < items.size(); i++) {
            if (findById(id).equals(items.get(i))) {
                items.set(i, item);
                break;
            }
        }
    }

    /**
     * Метод delete должен удалить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id.
     * @param id заявки 
     */
    public void delete(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                items.remove(i);
                break;
            }
        }
    }

    /**
     * Метод  findAll() возвращает заполненные ячейки массива this.items.
     * @return List<Item>
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     * @param key;
     * @return List<Item>
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(key)) {
                result.add(item);
            }
        }
        return result;
    }
}
