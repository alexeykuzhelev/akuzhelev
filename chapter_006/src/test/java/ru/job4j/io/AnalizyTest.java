package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 21.02.2021
 */

/**
 * Класс тестирует функционал для класса Analizy.
 */
public class AnalizyTest {

    String path = "./src/main/java/ru/job4j/io/resources/";

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void before() {
        Analizy.outPrintlnFile(path + "source.log");
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

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        Analizy.outPrintlnFile(source.getAbsolutePath());
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringJoiner rsl = new StringJoiner(System.lineSeparator());
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::add);
        }
        String expected = ("10:57:01;10:59:01"  + System.lineSeparator()
                + "11:01:02;11:02:02");
        assertThat(rsl.toString(), is(expected));
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
