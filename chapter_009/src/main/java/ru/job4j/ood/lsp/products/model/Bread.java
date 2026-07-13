package ru.job4j.ood.lsp.products.model;

import java.time.LocalDate;

/**
 * Класс, представляющий хлеб.
 */
public class Bread extends Food {
    public Bread(String name, LocalDate createDate, LocalDate expiryDate, double price) {
        super(name, createDate, expiryDate, price);
    }
}
