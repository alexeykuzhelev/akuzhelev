package ru.job4j.ood.lsp.products.model;

import java.time.LocalDate;

/**
 * Класс, представляющий молоко.
 */
public class Milk extends Food {
    public Milk(String name, LocalDate createDate, LocalDate expiryDate, double price) {
        super(name, createDate, expiryDate, price);
    }
}
