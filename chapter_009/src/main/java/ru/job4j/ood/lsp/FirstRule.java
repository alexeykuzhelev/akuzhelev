package ru.job4j.ood.lsp;

/*
 * Нарушение принципа LSP: усиление предусловия в подклассе.
 *
 * Базовый класс LibraryItem позволяет выдачу книг на любой срок (days > 0).
 * Подкласс RareBook усиливает предусловие, требуя days <= 7.
 * При подстановке RareBook вместо LibraryItem код, вызывающий lend(14),
 * ожидает успешную выдачу, но получает исключение.
 */

class LibraryItem {

    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public void lend(int days) {
        if (days < 1) { /* предусловие: срок должен быть положительным */
            throw new IllegalArgumentException("Срок выдачи книг должен быть не менее 1 дня!");
        }
        /* логика выдачи */
    }
}

class RareBook extends LibraryItem {

    public RareBook(String title) {
        super(title);
    }

    @Override
    public void lend(int days) {
        if (days < 1) {
            throw new IllegalArgumentException("Срок выдачи книг должен быть не менее 1 дня!");
        }
        if (days > 7) { /* предусловие усилено: редкие книги выдаются не более чем на 7 дней */
            throw new IllegalArgumentException("Редкие книги выдаются не более чем на 7 дней!");
        }
        /* логика выдачи */
    }
}

public class FirstRule {
    public static void main(String[] args) {
        LibraryItem item = new RareBook("Справочник редких монет");
        item.lend(14); /* Ожидаем успешную выдачу, но получаем исключение — предусловие усилено */
    }
}
