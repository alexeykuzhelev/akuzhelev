package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.11.2020
 */

/**
 * Класс реализует чтение-запись данных из файла/в файл через буферизированные потоки.
 */
public class LogFilter {
    /**
     * Метод должен прочитать файл и вернуть строки,
     * где предпоследнее число - это 404.
     */
    public static List<String> filter(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(fileName))) {
            Stream<String> linesStream = in.lines().filter(x -> x.contains(" 404 "));
            linesStream.forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Метод записывает результат фильтрации в файл.
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            out.write(String.join(System.lineSeparator(), log));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter(
                "./chapter_006/src/main/java/ru/job4j/io/resources/log.txt");
        save(log, "./chapter_006/src/main/java/ru/job4j/io/resources/404.txt");
        System.out.println("Результат фильтрации строк из log.txt файла: ");
        log.forEach(System.out::println);
    }
}
