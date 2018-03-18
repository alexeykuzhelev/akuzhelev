package ru.job4j.loop;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 18.03.2018
 */

public class Paint {
    /**
     * Построить пирамиду в псевдографике.
     */
    public String pyramid(int height) {
        // Буфер для результата.
        StringBuilder screen = new StringBuilder();
        //вычисляем ширину пирамиды
        int weight = 2 * height - 1;
        //внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            //внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
                //Для левой стороны галки выставляются с левого края, поэтому мы должны брать высоту,
                //равную ширине левой стороны пирамиды и вычитать текущий указатель на ячейку.
                //Так же, мы берем - 1 потому, что элементы в массиве начинаются с 0, а не с 1.
                //Для правой стороны мы ставим галки от центральной оси, поэтому сдвигаем на height - 1.
                //Так мы определяем, сколько галок будет на строке.
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            // Добавляем перевод строки.
            screen.append(System.lineSeparator());
        }
        // Получаем результат.
        return screen.toString();
    }
}
