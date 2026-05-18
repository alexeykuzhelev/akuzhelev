package ru.job4j.ood.lsp;

/*
 * Нарушение принципа LSP: ослабление постусловия в подклассе.
 *
 * Базовый класс OrderService гарантирует, что созданный заказ всегда
 * имеет корректную скидку (от 0 до 100%). Подкласс PromoOrderService
 * убирает эту проверку, позволяя создать заказ со скидкой 150%.
 * При подстановке PromoOrderService вместо OrderService код, полагающийся
 * на корректность скидки, получает невалидный заказ.
 */

class Order {

    private final int discount;

    private final int totalPrice;

    public Order(int discount, int totalPrice) {
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}

class OrderService {

    public Order createOrder(int discount, int totalPrice) {
        if (discount < 0 || discount > 100) { /* постусловие: скидка всегда в диапазоне 0-100% */
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100%!");
        }
        return new Order(discount, totalPrice);
    }
}

class PromoOrderService extends OrderService {

    @Override
    public Order createOrder(int discount, int totalPrice) {
        /* Постусловие ослаблено: проверка диапазона скидки убрана, заказ может иметь скидку > 100% */
        return new Order(discount, totalPrice);
    }
}

public class SecondRule {
    public static void main(String[] args) {
        OrderService service = new PromoOrderService();
        Order order = service.createOrder(150, 1000);
        /* Ожидаем скидку 0-100%, но получаем 150% — постусловие нарушено */
        System.out.println("Скидка: " + order.getDiscount() + "%");
    }
}
