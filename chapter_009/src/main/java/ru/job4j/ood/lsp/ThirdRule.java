package ru.job4j.ood.lsp;

/*
 * Нарушение принципа LSP: нарушение инварианта базового класса.
 *
 * Инвариант класса Rectangle: ширина и высота — независимые величины,
 * изменение одной не влияет на другую.
 * Класс Square (квадрат) наследует Rectangle, но переопределяет
 * setWidth и setHeight так, что изменение одной стороны меняет и другую.
 * При подстановке Square вместо Rectangle код, ожидающий независимость
 * сторон, получает неверный результат вычисления площади.
 */

class Rectangle {

    protected int width;

    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; /* инвариант нарушен: изменение ширины меняет высоту */
    }

    @Override
    public void setHeight(int height) {
        this.width = height; /* инвариант нарушен: изменение высоты меняет ширину */
        this.height = height;
    }
}

public class ThirdRule {
    public static void main(String[] args) {
        Rectangle rectangle = new Square(5);
        rectangle.setWidth(4);
        rectangle.setHeight(5);
        /* Ожидаем площадь 4 * 5 = 20, но получаем 5 * 5 = 25 — инвариант нарушен */
        System.out.println("Площадь: " + rectangle.getArea());
    }
}
