package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 15.12.2019
 */

/**
 * Класс тестирует функционал для класса RoleStore.
 */
public class RoleStoreTest {

    @Test
    public void whenAddElementShouldGetSameElementById() {
        RoleStore roleStore = new RoleStore(1);
        Role role = new Role("test");
        roleStore.add(role);
        Role result = roleStore.findById("test");
        assertThat(result, is(role));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementInFullContainerShouldReturnException() {
        RoleStore roleStore = new RoleStore(1);
        Role role1 = new Role("test1");
        Role role2 = new Role("test2");
        roleStore.add(role1);
        roleStore.add(role2);
    }

    @Test
    public void whenAddAndReplaceElementShouldReplaceIdAtFind() {
        RoleStore roleStore = new RoleStore(2);
        Role role1 = new Role("test1");
        Role role2 = new Role("test2");
        roleStore.add(role1);
        roleStore.replace("test1", role2);
        Role result = roleStore.findById("test2");
        assertThat(result, is(role2));
    }

    @Test
    public void whenReplaceElementAndGetReplacedElementShouldReturnNull() {
        RoleStore roleStore = new RoleStore(2);
        Role role1 = new Role("test1");
        Role role2 = new Role("test2");
        roleStore.add(role1);
        assertTrue(roleStore.replace("test1", role2));
        assertThat(roleStore.findById("test2"), is(role2));
        assertNull(roleStore.findById("test1"));
    }

    @Test
    public void whenRemoveWithoutAddElementsShouldReturnFalse() {
        RoleStore roleStore = new RoleStore(2);
        Role role1 = new Role("test1");
        roleStore.add(role1);
        assertFalse(roleStore.delete("test2"));
    }

    @Test
    public void whenFindByIdCannotFindIdShouldReturnNull() {
        RoleStore roleStore = new RoleStore(2);
        Role role1 = new Role("test1");
        roleStore.add(role1);
        assertNull(roleStore.findById("test2"));
    }
}
