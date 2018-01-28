package ru.job4j;

/**
* Class Calculate Класс для вывода сообщения в консоль.
*
* @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
* @version $Id$
* @since 24.01.2018
*/

public class Calculate {
	/**
    * Конструктор, вывод строки в консоль.
    * @param args - args.
    */
	public static void main(String[] args) {
		System.out.println("Hello World.");
	}
	
	/**
    * Method echo.
    * @param name Alexey Kuzhelev.
    * @return Echo plus Alexey Kuzhelev.
    */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}