package ru.job4j.map;

import java.util.Calendar;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 19.03.2020
 */

/**
 * Класс расширяет модель User с переопределением только Equals.
 */
public class UserOverrideEquals extends User {

    public UserOverrideEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserOverrideEquals uoe = (UserOverrideEquals) o;
        if (children != uoe.children) {
            return false;
        }
        if (name != null ? !name.equals(uoe.name) : uoe.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(uoe.birthday) : uoe.birthday == null;
    }
}
