package ru.job4j.map;

import java.util.Calendar;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 31.03.2020
 */

/**
 * Класс расширяет модель User с переопределением Equals и HashCode.
 */
public class UserOverrideEqualsAndHashCode extends User {

    public UserOverrideEqualsAndHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserOverrideEqualsAndHashCode uoe = (UserOverrideEqualsAndHashCode) o;
        if (children != uoe.children) {
            return false;
        }
        if (name != null ? !name.equals(uoe.name) : uoe.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(uoe.birthday) : uoe.birthday == null;
    }
}
