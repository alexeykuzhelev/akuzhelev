package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.07.2018
 */
 
public class TriangleTest {
	
    private final String ln = System.lineSeparator(); //перевод на новую строку	
	
	//тест, проверяющий формирование треугольника
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("  ^  ")
								.append(ln)
                                .append(" ^ ^ ")
								.append(ln)
                                .append("^^^^^")
                                .toString()
                )
        );
    }
}
