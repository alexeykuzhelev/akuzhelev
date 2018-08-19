package ru.job4j.tracker.models;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 17.08.2018
 */

/**
 * Class Item реализует поля и методы Заявки. 
 */
public class Item {
    /**
     * Идентификатор заявки.
     */	
    private String id;
    /**
     * Имя заявки.
     */	
    private String name;
    /**
     * Описание заявки.
     */		
    private String description;
    /**
     * Время создания заявки.
     */	
    private long create;
    /**
     * Комментарий к заявке.
     */	
    private String comment;
    /**
     * Перевод на новую строку.
     */		
    private final String ln = System.lineSeparator();

    /**
     * Конструктор-1 класса Item.
     */	
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Конструктор-2 класса Item.
     */	
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Дефолтный конструктор.
     */		
    public Item() { }

    /**
     * Геттеры и сеттеры
     */
	 
	/**
     * Метод возвращает идентификатор заявки.
     */	 
    public String getId() {
        return this.id;
    }
	/**
     * Метод устанавливает идентификатор заявки.
     */
    public void setId(String id) {
        this.id = id;
    }
	/**
     * Метод возвращает имя заявки.
     */
    public String getName() {
        return this.name;
    }
	/**
     * Метод устанавливает имя заявки.
     */
    public void setName(String name) {
        this.name = name;
    }
	/**
     * Метод возвращает описание заявки.
     */
    public String getDescription() {
        return this.description;
    }
	/**
     * Метод устанавливает описание заявки.
     */
    public void setDescription(String description) {
        this.description = description;
    }
	/**
     * Метод возвращает время заявки.
     */
    public long getCreate() {
        return this.create;
    }
	/**
     * Метод устанавливает время заявки.
     */
    public void setCreate(long create) {
        this.create = create;
    }
	/**
     * Метод возвращает комментарии заявки.
     */
    public String getComment() {
        return this.comment;
    }
	/**
     * Метод устанавливает комментарии заявки.
     */
    public void setComment() {
        this.comment = comment;
    }

    /**
     * Переопределяет метод toString().
     * @return строковое представление объекта.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id заявки: " + this.getId() + ln);
        sb.append("Имя заявки: " + this.getName() + ln);
        sb.append("Описание заявки: " + this.getDescription() + ln);
        sb.append("-------------------------------------------");
        return sb.toString();
    }
}
