package ru.job4j.ood.srp;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HtmlSequenceGenerator implements SequenceGenerator<String> {

    @Override
    public List<String> generate(int size) {
        Random random = new Random();
        List<Integer> numbers = IntStream.range(0, size)
                .map(i -> random.nextInt(100))
                .boxed()
                .collect(Collectors.toList());

         /*
         Нарушение SRP:
         Класс занимается преобразованием данных в HTML.
         Если нужно будет изменить тег <li> на <div> или добавить классы стилей,
         придется менять код генератора.
          */
        return numbers.stream()
                .map(num -> "<li>Value: " + num + "</li>")
                .collect(Collectors.toList());
    }

    @Override
    public void print(List<String> numbers) {
        /*
        Нарушение SRP:
         1. Класс сам решает, куда и как выводить данные (в консоль).
         2. Смешивание генерации и вывода.
         */
        System.out.println("<ul>");
        numbers.forEach(System.out::println);
        System.out.println("</ul>");
    }
}
