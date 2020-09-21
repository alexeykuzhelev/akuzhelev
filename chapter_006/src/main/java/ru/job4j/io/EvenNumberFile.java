package ru.job4j.io;

import java.io.FileInputStream;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 21.09.2020
 */

/**
 * Класс реализует чтение данных из файла.
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream(
                "./chapter_006/src/main/java/ru/job4j/io/resources/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            int min = 48;
            int max = 57;
            while ((read = in.read()) != -1) {
                if (rangeCheck(read, min, max) || read == 13 || read == 10) {
                    text.append((char) read);
                }
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line + "  Проверка, является ли число четным: "
                        + (Integer.parseInt(line) % 2 == 0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean rangeCheck(int read, int min, int max) {
        return read >= min && read <= max;
    }

}
