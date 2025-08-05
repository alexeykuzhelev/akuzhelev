package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    private static final String FIZZ_BUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final int FIZZ_DIVISOR = 3;
    private static final int BUZZ_DIVISOR = 5;

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var scanner = new Scanner(System.in);

        while (startAt < 100) {
            System.out.println(calculateFizzBuzz(startAt));
            startAt++;

            String answer = scanner.nextLine();
            if (!answer.equals(calculateFizzBuzz(startAt))) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 1;
                continue;
            }
            startAt++;
        }
    }

    static String calculateFizzBuzz(int number) {
        boolean isFizz = number % FIZZ_DIVISOR == 0;
        boolean isBuzz = number % BUZZ_DIVISOR == 0;

        if (isFizz && isBuzz) {
            return FIZZ_BUZZ;
        } else if (isFizz) {
            return FIZZ;
        } else if (isBuzz) {
            return BUZZ;
        } else {
            return String.valueOf(number);
        }
    }
}
