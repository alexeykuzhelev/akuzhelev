package ru.job4j.profession;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.05.2018
 */

/**
 * Class Engineer. Наследник от класса Profession. Описывает профессию инженера.
 * Имеет зависимость от класса House через параметры метода.
 */
public class Engineer extends Profession {

    /**
     * Метод строить дом
     * @return строка, содержащая имя инженера, адрес дома и выполняемое действие
     */
    public void build(House house) {
    }
} 
