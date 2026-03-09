package ru.job4j.ood.ocp.correct;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Обработка кредитной карты: " + amount);
    }
}
