package ru.job4j.io;

import java.io.File;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 10.03.2021
 */

/**
 * Класс выводит имя файла в директории и его размер.
 */
public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s",
                    file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s",
                    file.getAbsoluteFile()));
        }
        for (File subfile : file.listFiles()) {
            System.out.println("fileName: " + subfile.getName() + " fileSize: "
                    + subfile.length() / 1024 + "kB");
        }
    }
}
