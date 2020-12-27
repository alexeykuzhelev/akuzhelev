package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 26.12.2020
 */

/**
 * Класс тестирует функционал для класса Config.
 */
public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./src/main/java/ru/job4j/io/resources/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }
}
