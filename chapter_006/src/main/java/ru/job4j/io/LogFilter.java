package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(fileName))) {
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            System.out.println("Исходный текст log.txt файла: ");
            for (String line : lines) {
                if (line.contains("404")) {
                    result.add(line);
                }
                System.out.println(line);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> log = filter(
                "./chapter_006/src/main/java/ru/job4j/io/resources/log.txt");
        System.out.println("Результат фильтрации строк из log.txt файла: ");
        log.forEach(System.out::println);
    }
}
