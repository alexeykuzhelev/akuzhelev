package ru.job4j.generic;


/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 15.12.2019
 */

/**
 * Интерфейс описывает контейнеры для хранения объектов.
 */
public interface Store<T extends Base> {
	
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
