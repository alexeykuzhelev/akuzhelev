package ru.job4j.ood.ocp.correct;

public class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Обработка PayPal: " + amount);
    }
}
