package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import ru.job4j.tracker.models.*;
import ru.job4j.tracker.start.*;
import ru.job4j.tracker.storage.*;
import ru.job4j.tracker.input.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 27.01.2019
 */

/**
 * Класс StartUITest содержит JUnit тесты для для тестирования ввода из консоли.
 */
public class StartUITest {
    /**
     * Перевод на новую строку.
     */
    private final String ln = System.lineSeparator();
    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Поле содержит меню.
     */
    private final StringJoiner menu = new StringJoiner(ln, "", ln)
            .add("0. Adding new item")
            .add("1. Show all items")
            .add("2. Edit item")
            .add("3. Find item by Id")
            .add("4. Find items by name")
            .add("5. Exit Program")
            .add("6. Delete item");

    /**
     * Метод заменяет стандартный вывод в консоль на вывод в пямять.
     * Также создается новый объект Tracker.
     * Выполняется до запуска теста.
     */
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Метод возвращает обратно стандартный вывод в консоль.
     * Выполняется после запуска теста.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Тест, проверяющий добавление новой заявки по имени.
     * tracker - создаем объект Tracker.
     * input - создаем StubInput с последовательностью действий.
     * Создаем объект StartUI и вызываем метод init().
     * Проверяем, что нулевой элемент массива в трекере содержит имя, введенное при эмуляции.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(Arrays.asList("0", "test name", "test description", "y"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    /**
     * Тест, проверяющий добавление новой заявки по описанию.
     * tracker - создаем объект Tracker.
     * input - создаем StubInput с последовательностью действий.
     * Создаем объект StartUI и вызываем метод init().
     * Проверяем, что нулевой элемент массива в трекере содержит описание, введенное при эмуляции.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameDescription() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(Arrays.asList("0", "test name", "test description", "y"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getDescription(), is("test description"));
    }

    /**
     * Тест, проверяющий редактирование заявки по имени.
     * tracker - создаем объект Tracker.
     * Напрямую добавляем заявку в трэкер.
     * input - создаем StubInput с последовательностью действий для замены заявки.
     * Создаем объект StartUI и вызываем метод init().
     * Проверяем, что нулевой элемент массива в трекере содержит имя, введенное при эмуляции.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue1() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description"));
        Input input = new StubInput(Arrays.asList("2", item.getId(), "test replace", "заменили заявку", "y"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Тест, проверяющий редактирование заявки по описанию.
     * tracker - создаем объект Tracker.
     * Напрямую добавляем заявку в трэкер.
     * input - создаем StubInput с последовательностью действий для замены заявки.
     * Создаем объект StartUI и вызываем метод init().
     * Проверяем, что нулевой элемент массива в трекере содержит описание, введенное при эмуляции.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue2() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description"));
        Input input = new StubInput(Arrays.asList("2", item.getId(), "test replace", "заменили заявку", "y"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getDescription(), is("заменили заявку"));
    }

    /**
     * Тест, проверяющий по имени удаление заявки и сдвиг на ее место следующей заявки.
     * tracker - создаем объект Tracker.
     * Напрямую добавляем заявки в трэкер.
     * input - создаем StubInput с последовательностью действий для удаления первой заявки.
     * Создаем объект StartUI и вызываем метод init().
     * Проверяем, что нулевой элемент массива в трекере содержит имя следующей заявки.
     */
    @Test
    public void whenDeleteThenTrackerHasNextValue1() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        Input input = new StubInput(Arrays.asList("6", item1.getId(), "y"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test2"));
    }

    /**
     * Тест, проверяющий по описанию удаление заявки и сдвиг на ее место следующей заявки.
     * tracker - создаем объект Tracker.
     * Напрямую добавляем заявки в трэкер.
     * input - создаем StubInput с последовательностью действий для удаления первой заявки.
     * Создаем объект StartUI и вызываем метод init().
     * Проверяем, что нулевой элемент массива в трекере содержит описание следующей заявки.
     */
    @Test
    public void whenDeleteThenTrackerHasNextValue2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        Input input = new StubInput(Arrays.asList("6", item1.getId(), "y"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getDescription(), is("testDescription2"));
    }

    /**
     * Тест, проверяющий поиск заявки по имени.
     * tracker - создаем объект Tracker.
     * Напрямую добавляем заявку в трэкер.
     * input - создаем StubInput с последовательностью действий.
     * Создаем объект StartUI и вызываем метод init().
     * findByName - вызов метода, находящего заявку по имени и помещающего ее в массив result.
     * Проверяем, что нулевой элемент массива в трекере содержит имя найденной заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerFindItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description"));
        Input input = new StubInput(Arrays.asList("4", "test name", "y"));
        new StartUI(input, tracker).init();
        List<Item> result = tracker.findByName("test name");
        assertThat(result.get(0).getName(), is("test name"));
    }

    /**
     * Тест, проверяющий поиск заявки по id.
     * tracker - создаем объект Tracker.
     * Напрямую добавляем заявку в трэкер.
     * input - создаем StubInput с последовательностью действий.
     * Создаем объект StartUI и вызываем метод init().
     * result - находим заявку по id.
     */
    @Test
    public void whenUserAddItemThenTrackerFindItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description"));
        Input input = new StubInput(Arrays.asList("3", item.getId(), "y"));
        new StartUI(input, tracker).init();
        Item result = tracker.findById(item.getId());
        assertThat(result, is(item));
    }

    /**
     * Тест, проверяющий отображение всех заявок.
     * tracker - создаем объект Tracker.
     * Напрямую добавляем заявку в трэкер.
     * ln - перевод на новую строку.
     * input - создаем StubInput с последовательностью действий.
     * Создаем объект StartUI и вызываем метод init().
     */
    @Test
    public void whenShowAllThenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description"));
        Input input = new StubInput(Arrays.asList("1", "y"));
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Список существующих заявок. ----------")
                                .append(ln)
                                .append("Id заявки: ")
                                .append(item.getId())
                                .append(ln)
                                .append("Имя заявки: ")
                                .append(item.getName())
                                .append(ln)
                                .append("Описание заявки: ")
                                .append(item.getDescription())
                                .append(ln)
                                .append("-------------------------------------------")
                                .append(ln)
                                .toString()
                )
        );

    }
}
