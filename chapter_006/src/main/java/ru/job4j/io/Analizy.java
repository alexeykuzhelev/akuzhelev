package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 24.01.2021
 */

/**
 * Класс реализует регистрацию событий сервера.
 * Эти события записываются в файл, имеющий следующий формат:
 * TYPE Date
 * Type - может иметь 4 значения 200, 300, 400, 500
 * Date - это время проверки (формат часы:минуты:секунды)
 */
public class Analizy {
    /**
     * Метод unavailable должен находить диапазоны, когда сервер не работал.
     * Сервер не работал, если status = 400 или 500.
     */
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter write = new PrintWriter(new FileOutputStream(target))) {

            String line;
            Set<String> unavailableState = new HashSet<>(Arrays.asList("400", "500"));
            Set<String> availableState = new HashSet<>(Arrays.asList("200", "300"));
            Set<String> currentStatus = unavailableState;

            while ((line = read.readLine()) != null) {
                if (currentStatus == unavailableState
                        && unavailableState.contains(line.substring(0, 3))) {
                    write.print(line.substring(4) + ";");
                    currentStatus = availableState;
                } else if (currentStatus == availableState
                        && availableState.contains(line.substring(0, 3))) {
                    write.println(line.substring(4));
                    currentStatus = unavailableState;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String pathSource = "./chapter_006/src/main/java/ru/job4j/io/resources/source.log";
        String pathTarget = "./chapter_006/src/main/java/ru/job4j/io/resources/target.csv";
        try (PrintWriter out = new PrintWriter(
                new FileOutputStream(pathSource))) {
            out.println("200 10:56:01" + System.lineSeparator()
                    + "500 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "200 10:59:01" + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator()
                    + "200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(pathSource, pathTarget);
    }
}
