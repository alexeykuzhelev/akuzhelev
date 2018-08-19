package ru.job4j.tracker.start;

import ru.job4j.tracker.input.*;
import ru.job4j.tracker.storage.*;
import ru.job4j.tracker.actions.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 18.08.2018
 */

/**
 * Class StartUI - это точка входа в программу, т.е. должен иметь метод main.
 * Класс должен обеспечить полноценную работу всего приложения (трекера).
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Состояние выхода из программы.
     * Программа работает до тех пор, пока значение истинно.
     */
    private boolean exit = true;

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
     * Основой метод программы. Выполняет действия над заявкой.
     * fillActions - вызов метода, заполняющего массив меню действий и передача ему объекта StartUI.
     * show - вызов метода, показывающего меню.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            menu.show();
            int key = input.ask("select:", menu.getMenuRange());
            menu.select(key);
        } while (this.exit && !"y".equals(this.input.ask("Exit program?(y/n): ")));
    }

    /**
     * Метод приводит к выходу из программы.
     */
    public void stop() {
        this.exit = false;
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}
