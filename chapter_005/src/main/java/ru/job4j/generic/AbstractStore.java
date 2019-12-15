package ru.job4j.generic;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 15.12.2019
 */

/**
 * Класс реализует общий функционал для классов UserStore и RoleStore.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private final SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    /**
     * Метод возвращает индекс массива по указанному id его элемента.
     */
    private int getIndex(String id) {
        int index = 0;
        boolean exist = false;
        for (T model : simpleArray) {
            if (model.getId().equals(id)) {
                exist = true;
                break;
            }
            index++;
        }
        if (!exist) {
            index = -1;
        }
        return index;
    }

    /**
     * Метод добавляет указанный элемент (model) в массив.
     */
    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }

    /**
     * Метод заменяет указанным элементом (model) элемент массива,
     * определяя его индекс по id.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            this.simpleArray.set(index, model);
            result = true;
        }
        return result;
    }

    /**
     * Метод удаляет элемент массива, определяя его индекс по id.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            this.simpleArray.remove(index);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает элемент массива, определяя его индекс по id.
     */
    @Override
    public T findById(String id) {
        int index = getIndex(id);
        if (index == -1) {
            return null;
        }
        return this.simpleArray.get(index);
    }
}
