package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import ru.job4j.tracker.models.*;
import ru.job4j.tracker.start.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 16.06.2018
 */

public class TrackerTest {
    @Test
    public void whenFindItemById() {
        //тест, проверяющий получение заявки по id
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L); //создаем первую заявку
        tracker.add(item1); //добавляем заявку в трекер
        item1.setId("1111");  //проставляем id
        Item item2 = new Item("test2", "testDescription2", 4567L); //создаем вторую заявку
        tracker.add(item2); //добавляем заявку в трекер
        item2.setId("22222");  //проставляем id
        Item result = tracker.findById("1111"); //находим заявку по id
        assertThat(result, is(item1));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        //тест, проверяющий, что заявка отредактирована
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        //Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        //Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        //Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        //Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        //Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteFirstItem() {
        //тест, проверяющий удаление заявки и сдвиг на ее место следующей заявки
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        item1.setId("1111"); //проставляем id первой заявки
        Item item2 = new Item("test2", "testDescription2", 4567L);
        tracker.add(item2);
        item2.setId("22222"); //проставляем id второй заявки
        tracker.delete("1111"); //удаляем первую заявку
        //Проверяем, что заявки с таким id больше нет (возвращает null).
        assertNull(tracker.findById("1111"));
    }

    @Test
    public void findAllItem() {
        //тест, проверяющий создания нового массива заявок без null элементов
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 4567L);
        tracker.add(item2);
        Item[] result = tracker.findAll();
        assertThat(result, is(new Item[]{item1, item2}));
    }

    @Test
    public void whenFindItemByName() {
        //тест, проверяющий поиск заявки по имени
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 4567L);
        tracker.add(item2);
        Item[] result = tracker.findByName("test1");
        assertThat(result, is(new Item[] {item1}));
    }
}
