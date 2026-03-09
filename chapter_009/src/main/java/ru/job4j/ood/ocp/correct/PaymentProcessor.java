package ru.job4j.ood.ocp.correct;

/**
 * Процессор не нужно менять при добавлении новых способов оплаты
 */
public class PaymentProcessor {

    public void processPayment(PaymentMethod method, double amount) {
        method.processPayment(amount);
    }
}
