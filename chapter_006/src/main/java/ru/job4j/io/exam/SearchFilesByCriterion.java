package ru.job4j.io.exam;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 06.02.2022
 */

/**
 * Класс реализует программу поиска файлов по критерию.
 * Программа должна искать данные в заданном каталоге и подкаталогах.
 * Имя файла может задаваться, целиком, по маске, по регулярному выражению(не обязательно).
 * Программа должна собираться в jar и запускаться через java -jar find.jar -d=c:/ -n=*.txt -t=mask -o=log.txt
 * Ключи (параметры запуска):
 * -d - директория, в которой начинать поиск.
 * -n - имя файла, маска, либо регулярное выражение.
 * -t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.
 * -o - результат записать в файл.
 * Программа должна записывать результат в файл.
 * Для поиска и обработки файлов использован класс SearchFilePaths.
 * Реализована также валидация параметров запуска.
 */
public class SearchFilesByCriterion {
    public static void main(String[] args) throws IOException {
        ArgsNameValidateAndParse.validate(args);
        ArgsNameValidateAndParse argsNameParse = ArgsNameValidateAndParse.of(args);
        search(argsNameParse);
    }

    public static void search(ArgsNameValidateAndParse argsName) throws IOException {
        Path startDir = Paths.get(argsName.get("d"));
        Path outFile = Paths.get(argsName.get("o"));
        String searchingWord = argsName.get("n");
        String searchingType = argsName.get("t");

        SearchFilePaths searcher = new SearchFilePaths(predicate(searchingWord, searchingType));
        Files.walkFileTree(startDir, searcher);
        writeResultToLog(outFile, searcher.getPaths());
    }

    public static Predicate<Path> predicate(String searchingWord, String searchingType) {
        Predicate<Path> predicate = null;
        if ("name".equals(searchingType)) {
            predicate = p -> p.toFile().getName().equals(searchingWord);
        } else if ("mask".equals(searchingType)) {
            String replaceMask = searchingWord.replaceAll("\\*", ".\\*")
                .replaceAll("\\?", ".\\?");
            Pattern pattern = Pattern.compile(replaceMask);
            predicate = p -> pattern.matcher(p.toFile().getName()).matches();
        } else if ("regex".equals(searchingType)) {
            Pattern pattern = Pattern.compile(searchingWord);
            predicate = p -> pattern.matcher(p.toFile().getName()).matches();
        }
        return predicate;
    }

    public static void writeResultToLog(Path outFile, List<Path> pathList) throws IOException {
        try (
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(outFile.toFile())))) {
            pathList.forEach(pw::println);
        }
        System.out.println("Найдено файлов: " + pathList.size() + "\n"
            + "Результат записан в файл: " + outFile.toAbsolutePath());
    }
}
