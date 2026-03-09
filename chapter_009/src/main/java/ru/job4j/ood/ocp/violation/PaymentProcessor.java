package ru.job4j.ood.ocp.violation;

public class PaymentProcessor {

    public void processPaymentType(String paymentType, double amount) {
        switch (paymentType) {
            case "CREDIT_CARD" -> processCreditCard(amount);
            case "PAYPAL" -> processPayPal(amount);
            /* Добавление нового способа оплаты требует изменить этот метод, т.к. добавляется новый case.
               Также будет добавлен новый приватный метод */
            default -> throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
    }

    private void processCreditCard(double amount) {
        System.out.println("Обработка кредитной карты: " + amount);
    }

    private void processPayPal(double amount) {
        System.out.println("Обработка PayPal: " + amount);
    }

}
