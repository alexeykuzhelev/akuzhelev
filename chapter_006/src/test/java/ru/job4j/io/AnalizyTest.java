package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 24.01.2021
 */

/**
 * Класс тестирует функционал для класса Analizy.
 */
public class AnalizyTest {

    String path = "./src/main/java/ru/job4j/io/resources/";

    @Before
    public void before() {
        try (PrintWriter out = new PrintWriter(
                new FileOutputStream(path + "source.log"))) {
            out.println("200 10:56:01" + System.lineSeparator()
                    + "500 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "200 10:59:01" + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator()
                    + "200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenUnavailable() {
        Analizy analizy = new Analizy();
        analizy.unavailable(path + "source.log", path + "target.csv");
        try (BufferedReader read = new BufferedReader(
                new FileReader(path + "target.csv"))) {
            assertThat("10:57:01;10:59:01", is(read.readLine()));
            assertThat("11:01:02;11:02:02", is(read.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        File file = new File(path + "source.log");
        if (file.exists()) {
            file.deleteOnExit();
        }
        file = new File(path + "target.csv");
        if (file.exists()) {
            file.deleteOnExit();
        }
    }
}
