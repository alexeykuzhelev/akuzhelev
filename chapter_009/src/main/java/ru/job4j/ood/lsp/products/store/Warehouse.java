package ru.job4j.ood.lsp.products.store;

import ru.job4j.ood.lsp.products.model.Food;
import java.time.LocalDate;

/**
 * Хранилище продуктов - Склад (Warehouse).
 * 
 * Соблюдение LSP:
 * 1. Наследуется от AbstractStore и переопределяет метод accept() без сужения
 * типов данных или изменения ожидаемого контракта поведения.
 * 2. Не накладывает дополнительных ограничений на добавление продуктов (add()).
 */
public class Warehouse extends AbstractStore {
    @Override
    public boolean accept(Food food, LocalDate now) {
        double percent = calculateExpiryPercent(food, now);
        return percent >= 0 && percent < 25.0;
    }
}
