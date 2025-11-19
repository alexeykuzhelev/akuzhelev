package ru.job4j.ood.srp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoggingSequenceGenerator implements SequenceGenerator<Integer> {

    @Override
    public List<Integer> generate(int size) {
        Random random = new Random();
        List<Integer> result = IntStream.range(0, size)
                .map(i -> random.nextInt())
                .boxed()
                .collect(Collectors.toList());

        /*
        Нарушение SRP:
         Метод занимается "побочным эффектом" — записью в файл.
         Это смешивание бизнес-логики (генерация) и инфраструктурной логики (IO операции).
         */
        try (FileWriter writer = new FileWriter("generation_log.txt", true)) {
            writer.write("Generated " + size + " numbers at " + System.currentTimeMillis() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void print(List<Integer> numbers) {
        numbers.forEach(System.out::println);
    }
}
