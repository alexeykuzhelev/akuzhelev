package ru.job4j.tracker.start;

import ru.job4j.tracker.input.*;
import ru.job4j.tracker.storage.*;
import ru.job4j.tracker.actions.*;
import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 04.08.2018
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
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>(); //массив со значениями ключа
		//вызов метода, заполняющего массив меню действий и передача ему объекта StartUI
        menu.fillActions(this); 
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show(); //показать меню
            int key = input.ask("select:", range);
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
