package ru.job4j.ood.lsp.products.store;

import ru.job4j.ood.lsp.products.model.Food;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Базовый класс для всех хранилищ.
 * Реализует общую логику хранения продуктов и расчёта износа срока годности.
 * 
 * Соблюдение LSP:
 * 1. Содержит общие для всех хранилищ методы взаимодействия со списком
 * продуктов (add, getAll, clear).
 * 2. Метод accept(Food, LocalDate) намеренно не реализован, чтобы каждое
 * конкретное хранилище могло реализовать свои специфичные правила отбора, при этом
 * сигнатура метода и контракт поведения остаются неизменными.
 */
public abstract class AbstractStore implements Store {
    private final List<Food> products = new ArrayList<>();

    @Override
    public boolean add(Food food, LocalDate now) {
        return products.add(food);
    }

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void clear() {
        products.clear();
    }

    /**
     * Вычисляет процент израсходованного срока годности продукта на указанную дату.
     * Процент рассчитывается как отношение прошедшего времени с даты создания к
     * общему сроку годности:
     * (текущая дата - дата создания) / (дата окончания - дата создания) * 100%.
     * 
     * @param food продукт.
     * @param now  текущая дата.
     * @return процент израсходованного срока годности (от 0.0 до >= 100.0).
     */
    protected double calculateExpiryPercent(Food food, LocalDate now) {
        long totalDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        if (totalDays <= 0) {
            return 100.0;
        }
        long passedDays = ChronoUnit.DAYS.between(food.getCreateDate(), now);
        return ((double) passedDays / totalDays) * 100.0;
    }
}
