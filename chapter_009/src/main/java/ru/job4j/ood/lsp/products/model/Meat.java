package ru.job4j.ood.lsp.products.model;

import java.time.LocalDate;

/**
 * Класс, представляющий мясо.
 */
public class Meat extends Food {
    public Meat(String name, LocalDate createDate, LocalDate expiryDate, double price) {
        super(name, createDate, expiryDate, price);
    }
}
