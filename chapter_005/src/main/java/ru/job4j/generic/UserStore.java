package ru.job4j.generic;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 15.12.2019
 */

/**
 * Класс для хранения данных.
 * Инициализирует конструктор абстрактного суперкласса AbstractStore.
 * Функционал класса вынесен в абстрактный суперкласс AbstractStore.
 * Тип хранимых данных должен быть User.
 */
public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }
}
