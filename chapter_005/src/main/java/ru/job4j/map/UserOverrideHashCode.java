package ru.job4j.map;

import java.util.Calendar;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.03.2020
 */

/**
 * Класс расширяет модель User с переопределением только HashCode.
 */
public class UserOverrideHashCode extends User {

    public UserOverrideHashCode(String name, int children, Calendar birthday) {
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
        return super.equals(o);
    }
}
