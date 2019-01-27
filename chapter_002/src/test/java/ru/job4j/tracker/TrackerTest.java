package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.*;

import ru.job4j.tracker.models.*;
import ru.job4j.tracker.storage.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 27.01.2019
 */

/**
 * Class TrackerTest тестирует методы класса Tracker.
 */ 
public class TrackerTest {
    /**
     * Тест, проверяющий поиск заявки по id.
     * tracker - создаем объект Tracker.
     * item1, item2 - создаем первую и вторую заявки и добавляем их в трэкер.
     * result - находим заявку по id.
     */
    @Test
    public void whenFindItemById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 4567L);
        tracker.add(item2);
        Item result = tracker.findById(item1.getId());
        assertThat(result, is(item1));
    }

    /**
     * Тест, проверяющий, что заявка отредактирована.
     * tracker - создаем объект Tracker.
     * previous - создаем и добавляем первую заявку в трэкер, теперь в объект проинициализирован id.
	 * next - создаем новую заявку.
	 * replace - вызов метода, обновляющего заявку в трекере, проставляя старый id из previous. 
     * Проверяем, что заявка на месте previous имеет новое имя test2.
     */	
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription1", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест, проверяющий удаление заявки и сдвиг на ее место следующей заявки.
     * tracker - создаем объект Tracker.
     * item1, item2 - создаем первую и вторую заявки и добавляем их в трэкер.
     * delete - вызов метода, удаляющего первую заявку.
	 * Проверяем, что заявки с таким id больше нет (возвращает null).
     */
    @Test
    public void whenDeleteFirstItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 4567L);
        tracker.add(item2);
        tracker.delete(item1.getId());
        assertNull(tracker.findById(item1.getId()));
    }

    /**
     * Тест, проверяющий создания нового массива заявок без null элементов.
     * tracker - создаем объект Tracker.
     * item1, item2 - создаем первую и вторую заявки и добавляем их в трэкер.
     * findAll - вызов метода, возвращающего заполненные ячейки массива items.
	 * Создаем новый массив ArrayList и добавляем в него заявки.
     */	
    @Test
    public void findAllItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 4567L);
        tracker.add(item2);
        List<Item> result = tracker.findAll();
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        assertThat(result, is(expected));
    }

    /**
     * Тест, проверяющий проверяющий поиск заявки по имени.
     * tracker - создаем объект Tracker.
     * item1, item2 - создаем первую и вторую заявки и добавляем их в трэкер.
     * findByName - вызов метода, находящего заявку по имени и помещающего ее в массив result.
	 * Создаем новый массив ArrayList и добавляем в него первую заявку.
     */	
    @Test
    public void whenFindItemByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 4567L);
        tracker.add(item2);
        List<Item> result = tracker.findByName("test1");
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        assertThat(result, is(expected));
    }
}
