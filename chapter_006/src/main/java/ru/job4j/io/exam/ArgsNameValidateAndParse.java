package ru.job4j.io.exam;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 06.02.2022
 */

/**
 * Класс реализует обработку именованных аргументов и разбивку их на пары: ключ, значение.
 * Реализована также валидация параметров запуска.
 */
public class ArgsNameValidateAndParse {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    /**
     * Метод разбивает массив параметров на пары: ключ, значение.
     */
    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("parameters do not exist");
        }
        for (String arg : args) {
            String[] arrayArgs = arg.replaceFirst("-", "").split("=");
            if (arrayArgs.length != 2) {
                throw new IllegalArgumentException("parameter value missing");
            }
            values.put(arrayArgs[0], arrayArgs[1]);
        }
    }

    public static void validate(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException(
                "Неверный ввод аргументов!\n"
                    + " Запуск программы через java -jar target/find.jar\n"
                    + "-d=директория, в которой начинать поиск\n"
                    + "-n=маска, имя файла, либо регулярное выражение\n"
                    + "-t=тип поиска: mask,name,regex\n"
                    + "-o=путь к файлу с найденными результатами"
            );
        }
        Path startDir = Paths.get(of(args).get("d"));
        String searchingType = of(args).get("t");
        if (!"name".equals(searchingType) && !"mask".equals(searchingType) && !"regex".equals(searchingType)) {
            throw new IllegalArgumentException(
                "-t=тип поиска - может принимать только 3 определенных параметра: mask,name,regex\n"
            );
        }
        if (!startDir.toFile().exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", startDir.toFile().getAbsoluteFile()));
        }
        if (!startDir.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", startDir.toFile().getAbsoluteFile()));
        }
    }

    public static ArgsNameValidateAndParse of(String[] args) {
        ArgsNameValidateAndParse names = new ArgsNameValidateAndParse();
        names.parse(args);
        return names;
    }
}
