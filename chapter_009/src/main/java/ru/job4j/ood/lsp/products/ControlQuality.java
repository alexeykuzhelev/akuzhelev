package ru.job4j.ood.lsp.products;

import ru.job4j.ood.lsp.products.model.Food;
import ru.job4j.ood.lsp.products.store.Store;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс перераспределения продуктов в зависимости от срока годности.
 * 
 * Соблюдение LSP:
 * 1. Работает с абстракцией Store, не завязываясь на конкретные типы (Warehouse, Shop, Trash).
 * 2. Любой новый класс хранилища, реализующий Store, может быть добавлен в список stores
 * без изменения логики распределения и вызова методов, что делает их взаимозаменяемыми.
 */
public class ControlQuality {
    private final List<Store> stores;

    /**
     * Конструктор инициализирующий список хранилищ.
     * Реализует агрегацию в стиле StartUI/MenuTracker из проекта Tracker.
     *
     * @param stores список доступных хранилищ.
     */
    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    /**
     * Распределяет один продукт в подходящее хранилище.
     *
     * @param food продукт для распределения.
     * @param now  текущая дата.
     */
    public void distribute(Food food, LocalDate now) {
        for (Store store : stores) {
            if (store.accept(food, now)) {
                store.add(food, now);
                break;
            }
        }
    }

    /**
     * Перераспределяет все продукты из всех хранилищ повторно.
     * Метод извлекает все элементы, очищает хранилища и затем распределяет их
     * с помощью метода distribute. Это решает проблему сдвига индексов в коллекциях.
     *
     * @param now текущая дата.
     */
    public void resort(LocalDate now) {
        List<Food> temp = new ArrayList<>();
        for (Store store : stores) {
            temp.addAll(store.getAll());
            store.clear();
        }
        for (Food food : temp) {
            distribute(food, now);
        }
    }
}
