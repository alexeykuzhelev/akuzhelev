package ru.job4j.pseudo;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.07.2018
 */

/**
 * Класс Paint выводит информацию в консоль.
 */
public class Paint {
    /**
     * Метод должен печатать псевдокартинку на консоль.
     * @param shape фигура для прорисовки.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Вывод на экран треугольника и квадрата.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}
