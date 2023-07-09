package ru.job4j.pseudo;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.07.2018
 */

/**
 * Класс Square формирует квадрат.
 */
public class Square implements Shape {

    private final String ln = System.lineSeparator(); /*перевод на новую строку*/

    /**
     * Метод формирует квадрат через формирование строк.
     * @return квадрат в виде строк.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+ + + +");
        pic.append(ln);
        pic.append("+     +");
        pic.append(ln);
        pic.append("+     +");
        pic.append(ln);
        pic.append("+ + + +");
        return pic.toString();
    }
}
