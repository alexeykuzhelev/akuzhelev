package ru.job4j.tracker.actions;

import ru.job4j.tracker.models.*;
import ru.job4j.tracker.start.*;
import ru.job4j.tracker.storage.*;
import ru.job4j.tracker.input.*;
import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 27.01.2019
 */

/**
 * Класс MenuTracker реализует меню трэкера.
 */
public class MenuTracker {
	/**
	 * @param input хранит ссылку на объект ввода.
	 */
	private Input input;
	/**
	 * @param tracker хранит ссылку на объект трэкера заявок.
	 */
	private Tracker tracker;
	/**
	 * @param actions хранит ссылку на массив типа UserAction (действия пользователя).
	 */
	private List<UserAction> actions = new ArrayList<>();

	/**
	 * Конструктор.
	 *
	 * @param input   объект типа Input, реализующего интерфэйс Input.
	 * @param tracker объект типа Tracker.
	 */
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * Метод для получения длины массива меню.
	 *
	 * @return длину массива
	 */
	public int getActionsLentgh() {
		return this.actions.size();
	}

	/**
	 * Метод заполняет (инициализирует) массив меню действий.
	 *
	 * @param startUI объект класса StartUI
	 */
	public void fillActions(StartUI startUI) {
		this.actions.add(this.new AddItem(0, "Adding new item"));
		this.actions.add(this.new ShowItems(1, "Show all items"));
		this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
		this.actions.add(new FindItemById(3, "Find item by Id"));
		this.actions.add(new FindItemsByName(4, "Find items by name"));
		this.actions.add(new ExitProgram(5, "Exit Program", startUI));
	}

	/**
	 * Метод добавляет в массив меню действий новое действие.
	 *
	 * @param action добавляемое действие.
	 */
	public void addAction(BaseAction action) {
		this.actions.add(action);
	}

	/**
	 * Метод заполняет (инициализирует) массив со значениями ключа.
	 *
	 * @return List<Integer> - массив со значениями ключа
	 */
	public List<Integer> getMenuRange() {
		List<Integer> range = new ArrayList<>();
		for (int i = 0; i < this.getActionsLentgh(); i++) {
			range.add(i);
		}
		return range;
	}

	/**
	 * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
	 *
	 * @param key ключ операции (идентификатор действия).
	 */
	public void select(int key) {
		this.actions.get(key).execute(this.input, this.tracker);
	}

	/**
	 * Метод выводит на экран меню действий.
	 */
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}

	/**
	 * Не статический внутренний класс AddItem реализует добавление заявки в трэкер.
	 */
	private class AddItem extends BaseAction {
		/**
		 * Конструктор.
		 *
		 * @param key  ключ операции.
		 * @param name описание действия.
		 */
		public AddItem(int key, String name) {
			super(key, name);
		}

		/**
		 * Метод добавляет заявку.
		 *
		 * @param input   ввод пользователя.
		 * @param tracker - хранилище заявок.
		 */
		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.println("------------ Adding new item --------------");
			String name = input.ask("Please, provide item name:");
			String desc = input.ask("Please, provide item description:");
			Item item = new Item(name, desc);
			tracker.add(item);
			StringBuilder sb = new StringBuilder();
			sb.append(LN);
			sb.append("------------ New Item with Id : " + item.getId());
			sb.append(LN);
			sb.append("------------ New Item with Name : " + item.getName());
			sb.append(LN);
			sb.append("------------ New Item with Description : " + item.getDescription());
			sb.append(LN);
			System.out.println(sb.toString());
		}
	}

	/**
	 * Не статический внутренний класс ShowItems реализует вывод на экран списка заявок.
	 */
	private class ShowItems extends BaseAction {
		/**
		 * Конструктор.
		 *
		 * @param key  ключ операции.
		 * @param name описание действия.
		 */
		public ShowItems(int key, String name) {
			super(key, name);
		}

		/**
		 * Метод показывает все заявки в хранилище.
		 *
		 * @param input ввод пользователя, tracker - хранилище заявок.
		 */
		@Override
		public void execute(Input input, Tracker tracker) {
			StringBuilder sb = new StringBuilder();
			System.out.println("---------- Список существующих заявок. ----------");
			for (Item item : tracker.findAll()) {
				sb.append(item.toString());
				sb.append(LN);
				System.out.println(item.toString());
			}
		}
	}

	/**
	 * Статический внутренний класс EditItem реализует редактирование заявки.
	 */
	private static class EditItem extends BaseAction {
		/**
		 * Конструктор.
		 *
		 * @param key  ключ операции.
		 * @param name описание действия.
		 */
		public EditItem(int key, String name) {
			super(key, name);
		}

		/**
		 * Метод редактирует заявку в хранилище.
		 *
		 * @param input ввод пользователя, tracker - хранилище заявок.
		 *              findById - вызов метода, проверяющего, что такой item есть в трекере.
		 */
		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.println("------------ Редактирование заявки --------------");
			String id = input.ask("Введите id заявки, которую надо изменить: ");
			Item item = tracker.findById(id);
			if (item != null) {
				String newName = input.ask("Введите имя новой заявки: ");
				String newDescription = input.ask("Введите описание новой заявки: ");
				Item newItem = new Item(newName, newDescription);
				tracker.replace(id, newItem);
				System.out.println("------------ Заявка с Id: " + id + " изменена -----------");
			} else {
				System.out.println("Заявка не найдена, введите другой Id");
			}
		}
	}
}

/**
 * Внешний класс FindItemById реализует поиск заявки по id.
 */
class FindItemById extends BaseAction {
	/**
	 * Конструктор.
	 * @param key ключ операции.
	 * @param name описание действия.
	 */
	public FindItemById(int key, String name) {
		super(key, name);
	}

	/**
	 * Метод поиска заявки в хранилище по id.
	 * @param input ввод пользователя, tracker - хранилище заявок.
	 */
	@Override
	public void execute(Input input, Tracker tracker) {
		System.out.println("------------ Поиск заявки по id --------------");
		String id = input.ask("Введите id заявки, которую надо найти: ");
		Item item = tracker.findById(id);
		if (item == null) {
			System.out.println("Заявка с таким id не найдена ");
		} else {
			System.out.println("------------ Заявка с таким Id найдена -----------");
			System.out.println(item.toString());
		}
	}
}

/**
 * Внешний класс FindItemsByName реализует поиск заявки по имени.
 */
class FindItemsByName extends BaseAction {
	/**
	 * Конструктор.
	 * @param key ключ операции.
	 * @param name описание действия.
	 */
	public FindItemsByName(int key, String name) {
		super(key, name);
	}

	/**
	 * Метод поиска заявки в хранилище по имени.
	 * @param input ввод пользователя, tracker - хранилище заявок.
	 */
	@Override
	public void execute(Input input, Tracker tracker) {
		System.out.println("------------ Поиск заявки по имени --------------");
		String name = input.ask("Введите имя заявки, которую надо найти:");
		List<Item> items = tracker.findByName(name);
		if (items.size() == 0) {
			System.out.println("Заявка с таким именем не найдена");
		} else {
			System.out.println("Найдены такие заявки: ");
			for (Item item : items) {
				System.out.println("------------ Заявка с таким именем найдена -----------");
				System.out.println(item.toString());
			}
		}
	}
}

/**
 * Внешний класс ExitProgram реализует выход из программы.
 */
class ExitProgram extends BaseAction {
	/**
	 * Поле объекта класса StartUI.
	 */
	private final StartUI ui;

	/**
	 * Конструктор.
	 *
	 * @param key  ключ операции.
	 * @param name описание действия.
	 * @param ui   объект класса StartUI.
	 */
	public ExitProgram(int key, String name, StartUI ui) {
		super(key, name);
		this.ui = ui;
	}

	/**
	 * Метод завершения цикла и выхода из программы.
	 *
	 * @param input ввод пользователя, tracker - хранилище заявок.
	 */
	@Override
	public void execute(Input input, Tracker tracker) {
		System.out.println("------------ Выход из программы --------------");
		this.ui.stop();
	}
}
