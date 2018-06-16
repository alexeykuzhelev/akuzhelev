package ru.job4j.tracker.models;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 16.06.2018
 */

/**
 * Class Item реализует поля и методы Заявки. 
 */
public class Item {
    private String id; // Идентификатор заявки
    private String name; // Имя заявки
    private String description; // Описание заявки
    private long create; // Время создания заявки
    private String comment; // Комментарий к заявке

    public Item(String name, String description, long create) { // Конструктор класса Item
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item() { }  // дефолтный конструктор

    /**
     * Геттеры и сеттеры
     */
    public String getId() { //Возвращает идентификатор заявки
        return this.id;
    }

    public void setId(String id) { //Устанавливает идентификатор заявки
        this.id = id;
    }

    public String getName() { //Возвращает имя заявки
        return this.name;
    }

    public void setName(String name) { //Устанавливает имя заявки
        this.name = name;
    }

    public String getDescription() { //Возвращает описание заявки
        return this.description;
    }

    public void setDescription(String description) { //Устанавливает описание заявки
        this.description = description;
    }

    public long getCreate() { //Возвращает время заявки
        return this.create;
    }

    public void setCreate(long create) { //Устанавливает время заявки
        this.create = create;
    }

    public String getComment() { //Возвращает комментарии заявки
        return this.comment;
    }

    public void setComment() { //Устанавливает комментарии заявки
        this.comment = comment;
    }
}
