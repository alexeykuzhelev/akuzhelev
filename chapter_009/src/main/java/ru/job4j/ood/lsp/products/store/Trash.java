package ru.job4j.ood.lsp.products.store;

import ru.job4j.ood.lsp.products.model.Food;
import java.time.LocalDate;

/**
 * Хранилище продуктов - Мусорка (Trash).
 * 
 * Соблюдение LSP:
 * 1. Наследуется от AbstractStore и переопределяет метод accept() без нарушения контракта.
 * 2. Не накладывает дополнительных ограничений на добавление продуктов (add()).
 */
public class Trash extends AbstractStore {
    @Override
    public boolean accept(Food food, LocalDate now) {
        double percent = calculateExpiryPercent(food, now);
        return percent >= 100.0;
    }
}
