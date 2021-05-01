package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 01.05.2021
 */

/**
 * Класс реализует обработку именованных аргументов,
 * и разбивку их на пары: ключ, значение.
 */
public class ArgsName {

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

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
