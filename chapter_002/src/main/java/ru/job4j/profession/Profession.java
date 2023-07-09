package ru.job4j.profession;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.05.2018
 */
 
/**
 * Class Profession. Базовый класс для остальных профессий.
 */
public class Profession { 
    private String name;  /*поле содержит имя специалиста*/
    private String profession; /*поле содержит название профессии*/

    public Profession() { /*дефолтный конструктор*/
    }
	
	/*конструктор для инициализации полей*/
    public Profession(String name, String profession) {
        this.name = name;
		this.profession = profession; 
    }
	
    public String getName() { /*метод возвращает имя специалиста*/
        return name;
    }
	
    public String getProfession() { /*метод возвращает профессию*/
        return profession;
    }
}

