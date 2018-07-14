package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.07.2018
 */

/**
 * Класс PaintTest тестирует методы класса Paint.
 */
public class PaintTest {
    //поле содержит дефолтный вывод в консоль
    private final PrintStream stdout = System.out;
    //буфер для результата
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    //перевод на новую строку
    private final String ln = System.lineSeparator();

    /**
     * Метод заменяет стандартный вывод в консоль на вывод в пямять.
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

    @Test
    //тест, проверяющий формирование квадрата c выводом в память
    public void whenDrawSquare() {
        new Paint().draw(new Square()); //выполняем действия пишушиее в консоль
        //проверяем результат вычисления
        assertThat(
                new String(this.out.toByteArray()),
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
    }

    @Test
    //тест, проверяющий формирование треугольника c выводом в память
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle()); //выполняем действия пишушиее в консоль
        //проверяем результат вычисления
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(
                                ln, "", ln)
                                .add("  ^  ")
                                .add(" ^ ^ ")
                                .add("^^^^^")
                                .toString()
                )
        );
    }
}
