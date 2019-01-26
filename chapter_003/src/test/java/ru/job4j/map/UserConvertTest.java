package ru.job4j.map;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 27.01.2019
 */

/**
 * Класс тестирует конвертацию List в Map.
 */
public class UserConvertTest {
    @Test
    public void whenConvertListThenMap() {
        User user1 = new User(0, "Aleks", "Sochi");
        User user2 = new User(1, "Ivan", "Piter");
        List<User> list = Arrays.asList(user1, user2);
        UserConvert convertList = new UserConvert();
        HashMap<Integer, User> result = convertList.process(list);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(0, user1);
        expect.put(1, user2);
        assertThat(result, is(expect));
    }
}
