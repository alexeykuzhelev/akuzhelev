package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.03.2021
 */

/**
 * Класс реализует поиск в директории и поддиректориях дубликатов всех файлов
 *  и вывод их в консоль.
 * Используется встроенный механизм Java - интерфейс FileVisitor.
 * В интерфейсе FileVisitor использован только метод только visitFile.
 * Java последовательно передает в visitFile файлы, которые обрабатываются.
 * Класс SimpleFileVisitor уже реализует FileVisitor,
 * только переопределяя все методы с указанием на дальнейший обход CONTINUE.
 */
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private List<FileProperty> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long fileSize = Files.size(file);
        String fileName = file.toFile().getName();
        FileProperty fileProperty = new FileProperty(fileSize, fileName);
        if (foundFiles.isEmpty() || !foundFiles.contains(fileProperty)) {
            foundFiles.add(fileProperty);
        } else {
            System.out.println(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}
