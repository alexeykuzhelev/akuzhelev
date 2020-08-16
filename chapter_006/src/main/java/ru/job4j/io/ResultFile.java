package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 16.08.2020
 */

/**
 * Класс реализует запись данных в файл.
 */
public class ResultFile {
    public static void main(String[] args) {
        int[][] matrix = new Matrix().multiple(4);
            try (FileOutputStream out = new FileOutputStream(
                    "./chapter_006/src/main/java/ru/job4j/io/resources/result.txt")) {
                for (int[] ints : matrix) {
                    String strInts = Arrays.toString(ints);
                    out.write((strInts + System.lineSeparator()).getBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
