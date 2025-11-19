package ru.job4j.ood.srp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConfigurableSequenceGenerator implements SequenceGenerator<Integer> {

    @Override
    public List<Integer> generate(int size) {
        /*
        Нарушение SRP:
         Класс знает, как создать и настроить генератор случайных чисел и откуда брать параметры (парсинг файла).
         Он зависит от файловой системы и формата конфига.
         */
        int bound = 100;
        try {
            List<String> lines = Files.readAllLines(Path.of("app.properties"));
            for (String line : lines) {
                if (line.startsWith("bound=")) {
                    bound = Integer.parseInt(line.split("=")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Логика генерации */
        int finalBound = bound;
        return IntStream.range(0, size)
                .map(i -> (int) (Math.random() * finalBound))
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public void print(List<Integer> numbers) {
        numbers.forEach(System.out::println);
    }
}
