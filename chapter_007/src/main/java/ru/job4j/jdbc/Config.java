package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 26.12.2020
 */

/**
 * Класс реализует чтение файла конфигурации, содержащего пары ключ-знания.
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод загружает пару ключ-значение в карту Map values.
     * В файле могут быть пустые строки и комментарии их нужно пропускать.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(line -> line.matches(".+[=].+"))
                        .forEach(line -> values.put(line.substring(0, line.indexOf("=")),
                                                 line.substring(line.indexOf("=") + 1))
                                );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает значение ключа.
     */
    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config(
                "./chapter_006/src/main/java/ru/job4j/io/resources/app.properties");
        config.load();
        System.out.println("Результат чтения строк из файла app.properties: ");
        System.out.println(config + System.lineSeparator());
        System.out.println("Результат чтения строк из карты Map values: ");
        System.out.println(config.values);
    }
}
