package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.05.2021
 */

/**
 * Класс реализует утилиту для архивации папки.
 * Для архивации используется класс ZipOutputStream.
 * При запуске указывается папка, которую мы хотим архивировать.
 * В качестве ключа передается  расширения файлов, которые не нужно включать в архив.
 * Архив должен сохранять структуру проекта. То есть содержать подпапки.
 * Для тестирования кода в IDEA нужно прописать параметры запуска main метода.
 */
public class Zip {

    public boolean validDirectory(ArgsName argZip) {
        File file = new File(argZip.get("d"));
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not source directory %s",
                    file.getAbsoluteFile()));
        }
        return file.isDirectory();
    }

    public void packFiles(List<Path> sources, File target) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))
        ) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                zip.write(Files.readAllBytes(path));
            }
        }
    }

    public void packSingleFile(File source, File target) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))
        ) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            zip.write(Files.readAllBytes(source.toPath()));
        }
    }

    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("./chapter_006/pom.xml"),
                new File("./chapter_006/pom.zip")
        );

        ArgsName argZip = ArgsName.of(new String[]{args[0], args[1], args[2]});
        new Zip().validDirectory(argZip);
        List<Path> paths = Search.search(
                Paths.get(argZip.get("d")), p -> !p.toFile().getName().endsWith(argZip.get("e"))
        );

        new Zip().packFiles(paths, new File(argZip.get("o")));
    }
}
