package ru.job4j.analize;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 22.07.2020
 */

/**
 * Класс тестирует статистику об изменении коллекции.
 */
public class AnalizeTest {

    Analize.User user1 = new Analize.User(1, "Petrov");
    Analize.User user2 = new Analize.User(2, "Ivanov");
    Analize.User user2Changed = new Analize.User(2, "Sidorov");
    Analize.User user3 = new Analize.User(3, "Aleks");

    @Test
    public void whenPreviousChanged() {
        List<Analize.User> previous = Arrays.asList(user1, user2);
        List<Analize.User> current = Arrays.asList(user1, user2Changed, user3);
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.added, is(1));
        assertThat(info.deleted, is(0));
        assertThat(info.changed, is(1));
    }

    @Test
    public void whenPreviousEmpty() {
        List<Analize.User> previous = Arrays.asList();
        List<Analize.User> current = Arrays.asList(user1, user2Changed, user3);
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.added, is(3));
        assertThat(info.deleted, is(0));
        assertThat(info.changed, is(0));
    }

    @Test
    public void whenCurrentEmpty() {
        List<Analize.User> previous = Arrays.asList(user1, user2);
        List<Analize.User> current = Arrays.asList();
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.deleted, is(2));
        assertThat(info.changed, is(0));
    }
}
