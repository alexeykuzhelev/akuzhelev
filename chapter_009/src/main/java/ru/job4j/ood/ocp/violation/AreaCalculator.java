package ru.job4j.ood.ocp.violation;

public class AreaCalculator {

    public double calculateArea(Object shape) {
        double area = 0;

        if (shape instanceof Rectangle rect) {
            area = rect.getWidth() * rect.getHeight();
        } else if (shape instanceof Circle circle) {
            area = Math.PI * circle.getRadius() * circle.getRadius();
        }
        /* При добавлении новой фигуры нужно изменять этот метод - добавлять новый else if */

        return area;
    }
}

class Rectangle {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }
}
