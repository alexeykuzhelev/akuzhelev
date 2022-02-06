package ru.job4j.io.exam;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 06.02.2022
 */

/**
 * Класс реализует программу которая выводит содержимое всей директории,
 * включая вложенные директории.
 * Используется встроенный механизм Java - интерфейс FileVisitor.
 * В интерфейсе FileVisitor использован только метод только visitFile.
 * Java последовательно передает в visitFile файлы, которые обрабатываются.
 */
public class SearchFilePaths implements FileVisitor<Path> {

    private final Predicate<Path> condition;

    public SearchFilePaths(Predicate<Path> predicate) {
        this.condition = predicate;
    }

    private final List<Path> listPath = new ArrayList<>();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file)) {
            listPath.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    public List<Path> getPaths() {
        return listPath;
    }
}
