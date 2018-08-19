package ru.job4j.tracker.input;

import ru.job4j.tracker.exception.*;
import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 16.08.2018
 */

/**
 * Класс StubInput для тестирования ввода из консоли.
 */
public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки, ему нужно ввести:
     * 0 - выбор пункта меню "добавить новую заявку".
     * name - имя заявки
     * description - описание заявки
     * 6 - выйти из трекера.
     */
    private List<String> value;

    /**
     * Поле считает количество вызовов метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    /**
     * Конструктор StubInput принимает массив строк.
     * @param value - массив ответов пользователя.
     */
    public StubInput(List<String> value) {
        this.value = value;
        this.position = 0;
    }

    /**
     * Метод опрашивает пользователя.
     * Давайте рассмотрим, как работает этот метод.
     * У нас есть объект, в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и 
     * при следующем вызове он вернет нам новое значение.
	 * @exception MenuOutException создаем необрабатываемое исключение.
     */
    @Override
    public String ask(String question) {
        return this.value.get(this.position++);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
