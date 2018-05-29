package ru.job4j.profession;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.05.2018
 */

/**
 * Class Doctor. Наследник от класса Profession. Описывает профессию врача.
 * Имеет зависимость от класса Patient через параметры метода. 
 */
public class Doctor extends Profession {

	/**
	 * Метод лечить пациента
	 * @return строка, содержащая имя доктора, имя пациента и выполняемое действие
	 */
	public void heals(Patient patient) {
	}
}
