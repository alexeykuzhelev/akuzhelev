package ru.job4j.pseudo;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.07.2018
 */

/**
 * Класс PaintTest тестирует методы класса Paint.
 */
public class PaintTest {

    private final String ln = System.lineSeparator(); //перевод на новую строку	

    @Test
    //тест, проверяющий формирование квадрата c выводом в память
    public void whenDrawSquare() {
        PrintStream stdout = System.out; //получаем ссылку на стандартный вывод в консоль
        //создаем буфур для хранения вывода
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //заменяем стандартный вывод на вывод в пямять для тестирования
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square()); //выполняем действия пишушиее в консоль
        //проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+ + + +")
                                .append(ln)
                                .append("+     +")
                                .append(ln)
                                .append("+     +")
                                .append(ln)
                                .append("+ + + +")
                                .append(ln)
                                .toString()
                )
        );
        System.setOut(stdout); //возвращаем обратно стандартный вывод в консоль
    }

    @Test
    //тест, проверяющий формирование треугольника c выводом в память
    public void whenDrawTriangle() {
        PrintStream stdout = System.out; //получаем ссылку на стандартный вывод в консоль
        //создаем буфур для хранения вывода
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //заменяем стандартный вывод на вывод в пямять для тестирования
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle()); //выполняем действия пишушиее в консоль
        //проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  ^  ")
                                .append(ln)
                                .append(" ^ ^ ")
                                .append(ln)
                                .append("^^^^^")
                                .append(ln)
                                .toString()
                )
        );
        System.setOut(stdout); //возвращаем обратно стандартный вывод в консоль
    }
}
