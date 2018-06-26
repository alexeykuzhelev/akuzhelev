package ru.job4j.tracker.start;

import ru.job4j.tracker.models.*;
import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 24.06.2018
 */

/**
 * Class StartUI - это точка входа в программу, т.е. должен иметь метод main.
 * Класс должен обеспечить полноценную работу всего приложения (трекера).
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа всех заявок в трекере (хранилище).
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявок.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FIND_BY_ID = "4";

    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Перевод на новую строку.
     */
    private final String ln = System.lineSeparator();

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask(ln + "Введите пункт меню: ");
            if (ADD.equals(answer)) {
                // 0. Add new Item
                this.createItem(); //добавление заявки вынесено в отдельный метод
            } else if (SHOW_ALL.equals(answer)) {
                // 1. Show all items
                this.showAllItems(); //отображение всех заявок вынесено в отдельный метод
            } else if (EDIT.equals(answer)) {
                // 2. Edit item
                this.editItem(); //редактирование заявки вынесено в отдельный метод
            } else if (DELETE.equals(answer)) {
                // 3. Delete item
                this.deleteItem(); //удаление заявок вынесено в отдельный метод
            } else if (FIND_BY_ID.equals(answer)) {
                // 4. Find item by Id
                this.findItemById(); //поиск заявки по id вынесен в отдельный метод
            } else if (FIND_BY_NAME.equals(answer)) {
                // 5. Find items by name
                this.findItemByName(); //поиск заявки по имени вынесен в отдельный метод
            } else if (EXIT.equals(answer)) {
                // 6. Exit Program
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String description = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, description);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + " добавлена -----------");
    }

    /**
     * Метод показывает все заявки в хранилище.
     */
    private void showAllItems() {
        System.out.println("------------ Отображение всех заявок --------------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.println("Id заявки: " + item.getId() + ln
                    + "Имя заявки: " + item.getName() + ln
                    + "Описание заявки: " + item.getDescription() + ln
                    + "-------------------------------------------");
        }
    }

    /**
     * Метод реализует редактирование заявки в хранилище.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки, которую надо изменить: ");
        Item item = this.tracker.findById(id); //проверка, что такой item есть в трекере
        if (item != null) {
            String newName = this.input.ask("Введите имя новой заявки: ");
            String newDescription = this.input.ask("Введите описание новой заявки: ");
            Item newItem = new Item(newName, newDescription);
            this.tracker.replace(id, newItem);
            System.out.println("------------ Заявка с Id: " + id + " изменена -----------");
        } else {
            System.out.println("Заявка не найдена, введите другой Id");
        }
    }

    /**
     * Метод реализует удаление заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки, которую надо удалить: ");
        Item item = this.tracker.findById(id); //проверка, что такой item есть в трекере
        if (item != null) {
            this.tracker.delete(id);
            System.out.println("------------ Заявка с Id: " + id + " удалена -----------");
        } else {
            System.out.println("Заявка не найдена, введите другой Id");
        }
    }

    /**
     * Метод реализует поиск заявки по id.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки, которую надо найти: ");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с таким id не найдена ");
        } else {
            System.out.println("------------ Заявка с Id: " + id + " найдена -----------" + ln
                    + "Имя заявки: " + item.getName() + ln
                    + "Описание заявки: " + item.getDescription() + ln
                    + "-------------------------------------------");
        }
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки, которую надо найти:");
        Item[] items = this.tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Заявка с таким именем не найдена");
        } else {
            System.out.println("Найдены такие заявки: ");
            for (Item item : items) {
                System.out.println("------------ Заявка с именем: " + name + " найдена -----------" + ln
                        + "Id заявки: " + item.getId() + ln
                        + "Описание заявки: " + item.getDescription() + ln
                        + "-------------------------------------------");
            }
        }
    }

    /**
     * Метод выводит пункты меню.
     */
    private void showMenu() {
        System.out.println(new StringJoiner(ln, ln, "")
                .add("Меню: ")
                .add(" 0. Добавление новой заявки")
                .add(" 1. Показать все заявки")
                .add(" 2. Редактирование заявки")
                .add(" 3. Удаление заявки")
                .add(" 4. Поиск заявки по Id")
                .add(" 5. Поиск заявки по имени")
                .add(" 6. Выйти из программы")
        );
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
