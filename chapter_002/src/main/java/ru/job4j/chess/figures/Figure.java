package ru.job4j.chess.figures;

import ru.job4j.chess.exceptions.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 20.09.2018
 */

/**
 * Абстрактный класс Figure будет описывать абстрактное поведение шахматной доски.
 * Создаем на его основе другие фигуры.
 */
public abstract class Figure {
	/**
	 * Поле содержит координаты x, y фигуры на шахматной доске.
	 */
	public final Cell position;

	/**
	 * Конструктор.
	 * @param position - клетка на шахматной доске, куда добавили фигуру.
	 */
	public Figure(Cell position) {
		this.position = position;
	}

	/**
	 * Абстрактный метод возвращает текущую позицию фигуры на доске.
	 */
	public abstract Cell position();

	/**
	 * Абстрактный метод определяет путь фигуры.
	 * @param source исходная клетка на доске.
	 * @param dest   задает конечную клетку, куда ходим.
	 * @return если фигура может пойти на dest, то вернуть путь фигуры в виде массива клеток.
	 * @throws ImpossibleMoveException выбросить исключение, если фигура не может пойти на dest.
	 */
	public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

	/**
	 * Абстрактный метод должен создавать объект Figure с координатой Cell dest.
	 * Он создает копию фигуры для ее переноса в другую клетку на доске.
	 * @param dest клетка, на которой создать копию фигуры.
	 * @return копия фигуры.
	 */
	public abstract Figure copy(Cell dest);

	/**
	 * Метод проверяет, занимает ли фигура переданную клетку.
	 * @param cell - клетка на доске.
	 * @return true - фигура занимает клетку, false - фигура не занимает клетку.
	 */
	public boolean occupied(Cell cell) {
		return this.position.x == cell.x && this.position.y == cell.y;
	}

	/**
	 * Метод возвращает имя иконки фигуры, сответствующее имени ее класса.
	 */
	public String icon() {
		return String.format("%s.png", this.getClass().getSimpleName());
	}
}
