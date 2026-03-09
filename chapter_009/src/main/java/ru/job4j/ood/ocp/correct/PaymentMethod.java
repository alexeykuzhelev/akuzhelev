package ru.job4j.ood.ocp.correct;

/**
 * Абстракция для метода оплаты
 */
public interface PaymentMethod {
    void processPayment(double amount);
}
