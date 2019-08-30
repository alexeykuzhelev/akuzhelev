package ru.job4j.list;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 31.08.2019
 */

/**
 * Класс тестирует конвертацию ArrayList в двумерный массив и лист массивов в один лист Integer.
 */
public class ConvertList2ArrayTest {
    /**
     * Конвертация списка из 7 элементов в массив из 3 рядов.
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * Конвертация списка из 5 элементов в массив из 3 рядов.
     */
    @Test
    public void when5ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5),
                3
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * Тест конвертации листа массивов в один лист Integer (метод convert).
     */
    @Test
    public void when2ArrayThen1Integer() {
        List<int[]> list = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6}
        );
        ConvertList2Array convertList = new ConvertList2Array();
        List<Integer> result = convertList.convert(list);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}
