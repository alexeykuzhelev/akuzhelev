package ru.job4j.generic;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 15.12.2019
 */

/**
 * Класс тестирует функционал для класса UserStore.
 */
public class UserStoreTest {

    @Test
    public void whenAddElementShouldGetSameElementById() {
        UserStore userStore = new UserStore(1);
        User user = new User("test");
        userStore.add(user);
        User result = userStore.findById("test");
        assertThat(result, is(user));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementInFullContainerShouldReturnException() {
        UserStore userStore = new UserStore(1);
        User user1 = new User("test1");
        User user2 = new User("test2");
        userStore.add(user1);
        userStore.add(user2);
    }

    @Test
    public void whenAddAndReplaceElementShouldReplaceIdAtFind() {
        UserStore userStore = new UserStore(2);
        User user1 = new User("test1");
        User user2 = new User("test2");
        userStore.add(user1);
        userStore.replace("test1", user2);
        User result = userStore.findById("test2");
        assertThat(result, is(user2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenReplaceElementAndGetReplacedElementShouldReturnException() {
        UserStore userStore = new UserStore(2);
        User user1 = new User("test1");
        User user2 = new User("test2");
        userStore.add(user1);
        assertTrue(userStore.replace("test1", user2));
        assertThat(userStore.findById("test2"), is(user2));
        userStore.findById("test1");
    }

    @Test
    public void whenRemoveWithoutAddElementsShouldReturnFalse() {
        UserStore userStore = new UserStore(2);
        User user1 = new User("test1");
        userStore.add(user1);
        assertFalse(userStore.delete("test2"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenFindByIdCannotFindIdShouldReturnException() {
        UserStore userStore = new UserStore(2);
        User user1 = new User("test1");
        userStore.add(user1);
        userStore.findById("test2");
    }
}
