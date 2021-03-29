package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.03.2021
 */

/**
 * Класс реализует запуск обхода директорий и поддиректорий класса DuplicatesVisitor.
 * Для поиска и вывода дубликатов всех файлов использован класс DuplicatesVisitor.
 */
public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get("./");
        if (args.length != 0) {
            root = Paths.get(args[0]);
        }
        System.out.println("Найдены следующие дубликаты файлов:");
        Files.walkFileTree(root, new DuplicatesVisitor());
    }
}
