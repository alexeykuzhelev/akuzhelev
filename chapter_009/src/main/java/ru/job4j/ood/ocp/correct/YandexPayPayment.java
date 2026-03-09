package ru.job4j.ood.ocp.correct;

/**
 * Новый способ оплаты - создаем новый класс, не трогая существующий код
 */
public class YandexPayPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Обработка YandexPay: " + amount);
    }
}
