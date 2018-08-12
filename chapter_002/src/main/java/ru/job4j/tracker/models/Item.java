package ru.job4j.tracker.models;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.08.2018
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
    private final String ln = System.lineSeparator(); //перевод на новую строку

    public Item(String name, String description, long create) { //Конструктор-1 класса Item
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item(String name, String description) { //Конструктор-2 класса Item
        this.name = name;
        this.description = description;
    }

    public Item() { }  //дефолтный конструктор

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

    /**
     * Метод для вывода сообщения о добавлении новой заявки.
     * @return строковое представление объекта.
     */
    public String addNewItem() {
        StringBuilder sb = new StringBuilder();
        sb.append(ln);
        sb.append("------------ New Item with Id : " + this.getId());
        sb.append(ln);
        sb.append("------------ New Item with Name : " + this.getName());
        sb.append(ln);
        sb.append("------------ New Item with Description : " + this.getDescription());
        sb.append(ln);
        return sb.toString();
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
