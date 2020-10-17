package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 15.10.2020
 */

/**
 * Класс реализует чтение данных из файла через буферизированные потоки.
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

    public static void main(String[] args) {
        List<String> log = filter(
                "./chapter_006/src/main/java/ru/job4j/io/resources/log.txt");
        System.out.println("Результат фильтрации строк из log.txt файла: ");
        log.forEach(System.out::println);
    }
}
