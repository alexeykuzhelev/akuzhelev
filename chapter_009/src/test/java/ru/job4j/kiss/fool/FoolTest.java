package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoolTest {
    @Test
    void whenNumberIsMultipleOf3And5ThenReturnFizzBuzz() {
        assertEquals("FizzBuzz", Fool.calculateFizzBuzz(15));
        assertEquals("FizzBuzz", Fool.calculateFizzBuzz(30));
    }

    @Test
    void whenNumberIsMultipleOf3ThenReturnFizz() {
        assertEquals("Fizz", Fool.calculateFizzBuzz(3));
        assertEquals("Fizz", Fool.calculateFizzBuzz(6));
        assertEquals("Fizz", Fool.calculateFizzBuzz(9));
    }

    @Test
    void whenNumberIsMultipleOf5ThenReturnBuzz() {
        assertEquals("Buzz", Fool.calculateFizzBuzz(5));
        assertEquals("Buzz", Fool.calculateFizzBuzz(10));
        assertEquals("Buzz", Fool.calculateFizzBuzz(20));
    }

    @Test
    void whenNumberIsNotMultipleOf3Or5ThenReturnNumber() {
        assertEquals("1", Fool.calculateFizzBuzz(1));
        assertEquals("2", Fool.calculateFizzBuzz(2));
        assertEquals("4", Fool.calculateFizzBuzz(4));
        assertEquals("7", Fool.calculateFizzBuzz(7));
    }
}
