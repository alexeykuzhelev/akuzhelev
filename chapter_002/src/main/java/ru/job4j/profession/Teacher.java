package ru.job4j.profession;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.05.2018
 */

/**
 * Class Teacher. Наследник от класса Profession. Описывает профессию учителя.
 * Имеет зависимость от класса Student через параметры метода.
 */
public class Teacher extends Profession {

    /**
     * Метод учить студента
     * @return строка, содержащая имя учителя, имя студента и выполняемое действие
     */
    public void learn(Student student) {
    }
}  
