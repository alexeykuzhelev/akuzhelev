package ru.job4j.ood.lsp.products;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.products.model.Bread;
import ru.job4j.ood.lsp.products.model.Food;
import ru.job4j.ood.lsp.products.model.Meat;
import ru.job4j.ood.lsp.products.model.Milk;
import ru.job4j.ood.lsp.products.store.Shop;
import ru.job4j.ood.lsp.products.store.Store;
import ru.job4j.ood.lsp.products.store.Trash;
import ru.job4j.ood.lsp.products.store.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlQualityTest {

    @Test
    public void whenExpiryPercentLessThan25ThenWarehouse() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality cq = new ControlQuality(List.of(warehouse, shop, trash));

        LocalDate now = LocalDate.of(2026, 7, 13);
        Food milk = new Milk("Milk", LocalDate.of(2026, 7, 12), LocalDate.of(2026, 7, 22), 100.0);

        cq.distribute(milk, now);

        assertThat(warehouse.getAll()).contains(milk);
        assertThat(shop.getAll()).isEmpty();
        assertThat(trash.getAll()).isEmpty();
        assertThat(milk.getDiscount()).isEqualTo(0.0);
    }

    @Test
    public void whenExpiryPercentBetween25And75ThenShopWithoutDiscount() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality cq = new ControlQuality(List.of(warehouse, shop, trash));

        LocalDate now = LocalDate.of(2026, 7, 5);
        Food bread = new Bread("Bread", LocalDate.of(2026, 7, 1), LocalDate.of(2026, 7, 11), 50.0);

        cq.distribute(bread, now);

        assertThat(shop.getAll()).contains(bread);
        assertThat(warehouse.getAll()).isEmpty();
        assertThat(trash.getAll()).isEmpty();
        assertThat(bread.getDiscount()).isEqualTo(0.0);
    }

    @Test
    public void whenExpiryPercentBetween75And100ThenShopWith20PercentDiscount() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality cq = new ControlQuality(List.of(warehouse, shop, trash));

        LocalDate now = LocalDate.of(2026, 7, 9);
        Food meat = new Meat("Meat", LocalDate.of(2026, 7, 1), LocalDate.of(2026, 7, 11), 200.0);

        cq.distribute(meat, now);

        assertThat(shop.getAll()).contains(meat);
        assertThat(warehouse.getAll()).isEmpty();
        assertThat(trash.getAll()).isEmpty();
        assertThat(meat.getDiscount()).isEqualTo(20.0);
    }

    @Test
    public void whenExpiryPercentEqualsOrGreaterThan100ThenTrash() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality cq = new ControlQuality(List.of(warehouse, shop, trash));

        LocalDate now = LocalDate.of(2026, 7, 11);
        Food milk = new Milk("Milk", LocalDate.of(2026, 7, 1), LocalDate.of(2026, 7, 11), 100.0);

        cq.distribute(milk, now);

        assertThat(trash.getAll()).contains(milk);
        assertThat(warehouse.getAll()).isEmpty();
        assertThat(shop.getAll()).isEmpty();
    }

    @Test
    public void whenResortThenProductsAreRedistributed() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality cq = new ControlQuality(List.of(warehouse, shop, trash));

        /* Сначала распределяем продукты на дату 2026-07-02 */
        LocalDate firstDate = LocalDate.of(2026, 7, 2);
        /* износ 10% - продукты загружаются в склад Warehouse */
        Food milk = new Milk("Milk", LocalDate.of(2026, 7, 1), LocalDate.of(2026, 7, 11), 100.0);
        Food bread = new Bread("Bread", LocalDate.of(2026, 7, 1), LocalDate.of(2026, 7, 11), 50.0);

        cq.distribute(milk, firstDate);
        cq.distribute(bread, firstDate);

        assertThat(warehouse.getAll()).containsExactlyInAnyOrder(milk, bread);
        assertThat(shop.getAll()).isEmpty();
        assertThat(trash.getAll()).isEmpty();

       /* Спустя время (на дату 2026-07-09), перераспределяем (resort)
        milk -> 80% (магазин со скидкой 20%)
        bread -> 80% (магазин со скидкой 20%) */
        LocalDate secondDate = LocalDate.of(2026, 7, 9);
        cq.resort(secondDate);

        assertThat(warehouse.getAll()).isEmpty();
        assertThat(shop.getAll()).containsExactlyInAnyOrder(milk, bread);
        assertThat(trash.getAll()).isEmpty();
        assertThat(milk.getDiscount()).isEqualTo(20.0);
        assertThat(bread.getDiscount()).isEqualTo(20.0);
    }
}
