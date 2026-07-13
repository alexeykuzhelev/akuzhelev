package ru.job4j.ood.lsp.products.store;

import ru.job4j.ood.lsp.products.model.Food;
import java.time.LocalDate;

/**
 * Хранилище продуктов - Магазин (Shop).
 * 
 * Соблюдение LSP:
 * 1. Наследуется от AbstractStore и переопределяет метод accept() без нарушения контракта.
 * 2. Переопределяет метод add() для автоматического применения скидки 20% к цене,
 * если до истечения срока годности осталось мало времени (израсходовано >= 75%).
 * Это поведение согласуется с контрактом Store, так как мы возвращаем true при
 * успешной вставке, не нарушая работу клиентов.
 */
public class Shop extends AbstractStore {
    private static final double DISCOUNT_THRESHOLD_PERCENT = 75.0;
    private static final double DISCOUNT_PERCENTAGE = 20.0;

    @Override
    public boolean accept(Food food, LocalDate now) {
        double percent = calculateExpiryPercent(food, now);
        return percent >= 25.0 && percent < 100.0;
    }

    @Override
    public boolean add(Food food, LocalDate now) {
        double percent = calculateExpiryPercent(food, now);
        if (percent >= DISCOUNT_THRESHOLD_PERCENT) {
            food.setDiscount(DISCOUNT_PERCENTAGE);
        }
        return super.add(food, now);
    }
}
