package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.*;

import ru.job4j.tracker.input.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 18.08.2018
 */

/**
 * Класс ValidateInputTest содержит JUnit тесты для тестирования кода валидации данных.
 */
public class ValidateInputTest {
    /**
     * Байтовый поток вывода (буфер для результата).
     * Для проверки вывода программы на соответствие ожидаемому.
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    /**
     * Стандартный поток вывода.
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream out = System.out;

    /**
     * Метод заменяет стандартный вывод в консоль на вывод в пямять.
     * Устанавливатся байтовый поток вывода. Выполняется до запуска теста.
     */
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Метод возвращает обратно стандартный вывод в консоль (стандартный поток вывода).
     * Выполняется после запуска теста.
     */
    @After
    public void loadSysStd() {
        System.setOut(this.out);
    }

    /**
     * Тест, проверяющий вывод программы, когда вместо числа введены другие данные.
     */	
    @Test
    public void whenInvalidInput1() {
        ValidateInput input = new ValidateInput(
                new StubInput(Arrays.asList("invalid", "1"))
        );
        input.ask("Enter", Arrays.asList(1));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, enter validate data again.%n")
                )
        );
    }

    /**
     * Тест, проверяющий вывод программы, когда введен некорректный пункт меню.
     */		
    @Test
    public void whenInvalidInput2() {
        ValidateInput input = new ValidateInput(
                new StubInput(Arrays.asList("-1", "1"))
        );
        input.ask("Enter", Arrays.asList(1));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, select key from menu.%n")
                )
        );
    }

    /**
     * Тест, проверяющий вывод программы, когда введен корректный пункт меню.
     */	
    @Test
    public void whenValidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(Arrays.asList("1", "test name"))
        );
        int key = input.ask("Enter", Arrays.asList(0, 1));
        System.out.println(key);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("1%n")
                )
        );
    }
}
