package ru.job4j.cache;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Класс реализует загрузку файла
 */
public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    /**
     * Конструктор принимает директорию для кэшируемых файлов
     *
     * @param cachingDir Директория для кэшируемых файлов
     */
    public DirFileCache(String cachingDir) {
        validateDir(cachingDir);
        this.cachingDir = cachingDir;
    }

    private static void validateDir(String dirName) {
        File fileDir = new File(dirName);
        if (!fileDir.exists()) {
            throw new IllegalArgumentException(String.format("Директория %s не существует", fileDir.getAbsoluteFile()));
        }
        if (!fileDir.isDirectory()) {
            throw new IllegalArgumentException(String.format("Не директория: %s", fileDir.getAbsoluteFile()));
        }
    }

    static void validateFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Файл %s не существует.", file.getAbsoluteFile()));
        }
        if (!file.canRead()) {
            throw new IllegalArgumentException("Доступ к чтению из файла ограничен");
        }
        if (!file.canWrite()) {
            throw new IllegalArgumentException("Доступ к записи в файл ограничен");
        }
    }

    /**
     * Метод загружает содержимое файла из указанной директории
     *
     * @param key Имя файла
     * @return Содержимое файла
     */
    @Override
    protected String load(String key) {
        String result = null;
        validateFile(cachingDir + key);
        try {
            result = Files.readString(Paths.get(cachingDir + key));
        } catch (IOException e) {
            System.out.printf("Ошибка при загрузке файла: %s%n", key);
            e.printStackTrace();
        }
        return result;
    }
}
