package ru.job4j.departments;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 31.08.2019
 */

public class DepartmentsTest {
    /**
     * Тест проверяет добавление отсутствующих строк с кодом верхнеуровнего подразделения.
     */
    @Test
    public void whenMissed() {
        Departments deps = new Departments();
        List<String> input = List.of("k1/sk1");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k1", "sk1"))
        );
        List<Departments.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    /**
     * Тест проверяет сортировку списка подразделений по возрастанию.
     */
    @Test
    public void whenAsc() {
        Departments deps = new Departments();
        List<String> input = List.of("k1/sk1", "k2");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k1", "sk1")),
                new Departments.Org(List.of("k2"))
        );
        List<Departments.Org> result = deps.sortAsc(deps.convert(input));
        assertThat(result, is(expect));
    }

    /**
     * Тест проверяет сортировку списка подразделений по убыванию.
     */
    @Test
    public void whenDesc() {
        Departments deps = new Departments();
        List<String> input = List.of("k1/sk1", "k2");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k2")),
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k1", "sk1"))
        );
        List<Departments.Org> result = deps.sortDesc(deps.convert(input));
        assertThat(result, is(expect));
    }
}
