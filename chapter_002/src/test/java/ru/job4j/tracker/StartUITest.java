package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.job4j.tracker.models.*;
import ru.job4j.tracker.start.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 03.07.2018
 */

/**
 * Класс StartUITest содержит JUnit тесты для для тестирования ввода из консоли.
 */
public class StartUITest {
    @Test
    //тест, проверяющий добавление новой заявки
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker(); //создаём Tracker
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "test description", "6"});
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    //тест, проверяющий редактирование заявки
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker(); //создаём Tracker
        Item item = tracker.add(new Item("test name", "test description")); //напрямую добавляем заявку
        //создаём StubInput с последовательностью действий для замены заявки
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    //тест, проверяющий удаление заявки и сдвиг на ее место следующей заявки
    public void whenDeleteThenTrackerHasNextValue() {
        Tracker tracker = new Tracker(); //создаём Tracker
        //напрямую добавляем заявки
        Item item1 = new Item("test1", "testDescription1");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        //создаём StubInput с последовательностью действий для удаления первой заявки
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        //проверяем, что нулевой элемент массива в трекере содержит имя следующей заявки
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }

    @Test
    //тест, проверяющий поиск заявки по имени	
    public void whenUserAddItemThenTrackerFindItemByName() {
        Tracker tracker = new Tracker(); //создаём Tracker
        Item item = tracker.add(new Item("test name", "test description")); //напрямую добавляем заявку
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"5", "test name", "6"});
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        Item[] result = tracker.findByName("test name"); //находим заявку по имени
        //проверяем, что нулевой элемент массива в трекере содержит имя найденной заявки
        assertThat(result[0].getName(), is("test name"));
    }

    @Test
    //тест, проверяющий поиск заявки по id
    public void whenUserAddItemThenTrackerFindItemById() {
        Tracker tracker = new Tracker(); //создаём Tracker
        Item item = tracker.add(new Item("test name", "test description")); //напрямую добавляем заявку
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        Item result = tracker.findById(item.getId()); //находим заявку по id
        assertThat(result, is(item));
    }
}
