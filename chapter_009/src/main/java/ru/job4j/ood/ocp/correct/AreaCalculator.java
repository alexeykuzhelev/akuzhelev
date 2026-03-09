package ru.job4j.ood.ocp.correct;

/**
 * Калькулятор не нужно менять, т.к. вызывается метод calculateArea в том классе,
 * на который ссылается параметр shape с интерфейсным типом
 */
public class AreaCalculator {

    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
