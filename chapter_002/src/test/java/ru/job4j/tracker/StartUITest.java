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
 * @since 03.08.2018
 */

/**
 * Класс StartUITest содержит JUnit тесты для для тестирования ввода из консоли.
 */
public class StartUITest {
    //поле трэкера заявок
    private Tracker tracker;
    //поле содержит дефолтный вывод в консоль
    private final PrintStream stdout = System.out;
    //буфер для результата
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    //перевод на новую строку
    private final String ln = System.lineSeparator();
    //поле содержит меню
    private final StringJoiner menu = new StringJoiner(ln, "", ln)
            .add("0. Adding new item")
            .add("1. Show all items")
            .add("2. Edit item")
            .add("3. Delete item")
            .add("4. Find item by Id")
            .add("5. Find items by name")
            .add("6. Exit Program");

    /**
     * Метод заменяет стандартный вывод в консоль на вывод в пямять.
     * Также создается новый объект Tracker.
     * Выполняется до запуска теста.
     */
    @Before
    public void loadOutput() {
        this.tracker = new Tracker(); //создаём Tracker
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

    @Test
    //тест, проверяющий добавление новой заявки по имени
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(Arrays.asList(new String[]{"0", "test name", "test description", "y"}));
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    //тест, проверяющий добавление новой заявки по описанию
    public void whenUserAddItemThenTrackerHasNewItemWithSameDescription() {
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(Arrays.asList(new String[]{"0", "test name", "test description", "y"}));
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        //проверяем, что нулевой элемент массива в трекере содержит описане, введённое при эмуляции
        assertThat(tracker.findAll().get(0).getDescription(), is("test description"));
    }

    @Test
    //тест, проверяющий редактирование заявки по имени
    public void whenUpdateThenTrackerHasUpdatedValue1() {
        Item item = tracker.add(new Item("test name", "test description")); //напрямую добавляем заявку
        //создаём StubInput с последовательностью действий для замены заявки
        Input input = new StubInput(Arrays.asList(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"}));
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    //тест, проверяющий редактирование заявки по описанию
    public void whenUpdateThenTrackerHasUpdatedValue2() {
        Item item = tracker.add(new Item("test name", "test description")); //напрямую добавляем заявку
        //создаём StubInput с последовательностью действий для замены заявки
        Input input = new StubInput(Arrays.asList(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"}));
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        //проверяем, что нулевой элемент массива в трекере содержит описане, введённое при эмуляции
        assertThat(tracker.findById(item.getId()).getDescription(), is("заменили заявку"));
    }

    @Test
    //тест, проверяющий по имени удаление заявки и сдвиг на ее место следующей заявки
    public void whenDeleteThenTrackerHasNextValue1() {
        //напрямую добавляем заявки
        Item item1 = new Item("test1", "testDescription1");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        //создаём StubInput с последовательностью действий для удаления первой заявки
        Input input = new StubInput(Arrays.asList(new String[]{"3", item1.getId(), "y"}));
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        //проверяем, что нулевой элемент массива в трекере содержит имя следующей заявки
        assertThat(tracker.findAll().get(0).getName(), is("test2"));
    }

    @Test
    //тест, проверяющий по описанию удаление заявки и сдвиг на ее место следующей заявки
    public void whenDeleteThenTrackerHasNextValue2() {
        //напрямую добавляем заявки
        Item item1 = new Item("test1", "testDescription1");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        //создаём StubInput с последовательностью действий для удаления первой заявки
        Input input = new StubInput(Arrays.asList(new String[]{"3", item1.getId(), "y"}));
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        //проверяем, что нулевой элемент массива в трекере содержит описание следующей заявки
        assertThat(tracker.findAll().get(0).getDescription(), is("testDescription2"));
    }

    @Test
    //тест, проверяющий поиск заявки по имени	
    public void whenUserAddItemThenTrackerFindItemByName() {
        Item item = tracker.add(new Item("test name", "test description")); //напрямую добавляем заявку
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(Arrays.asList(new String[]{"5", "test name", "y"}));
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        List<Item> result = tracker.findByName("test name"); //находим заявку по имени
        //проверяем, что нулевой элемент массива в трекере содержит имя найденной заявки
        assertThat(result.get(0).getName(), is("test name"));
    }

    @Test
    //тест, проверяющий поиск заявки по id
    public void whenUserAddItemThenTrackerFindItemById() {
        Item item = tracker.add(new Item("test name", "test description")); //напрямую добавляем заявку
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(Arrays.asList(new String[]{"4", item.getId(), "y"}));
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        Item result = tracker.findById(item.getId()); //находим заявку по id
        assertThat(result, is(item));
    }

    @Test
    //тест, проверяющий отображение всех заявок
    public void whenShowAllThenShowAllItems() {
        Item item = tracker.add(new Item("test name", "test description")); //напрямую добавляем заявку
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(Arrays.asList(new String[]{"1", "y"}));
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
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
