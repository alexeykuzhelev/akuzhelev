package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.07.2018
 */
 
public class SquareTest {
	
    private final String ln = System.lineSeparator(); /*перевод на новую строку*/
	
	/*тест, проверяющий формирование квадрата*/
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("+ + + +")
								.append(ln)
                                .append("+     +")
								.append(ln)
                                .append("+     +")
								.append(ln)
                                .append("+ + + +")
                                .toString()
                )
        );
    }
}
