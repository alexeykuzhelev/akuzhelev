package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 10.06.2019
 */

/**
 * Класс реализует подсчет функции в диапазоне.
 */ 
public class Diapason {
	
    /**
     * Метод реализует подсчет функции в диапазоне.
     * @param start - начало диапазона
     * @param end - конец диапазона
     * @param func - функция для подсчета
     * @return List - список значений, полученных в результате подсчета
     **/	
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double i = start; i != end; i++) {
            result.add(func.apply(i));
        }
        return result;
    }
}
