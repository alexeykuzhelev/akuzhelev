package ru.job4j.io;

import java.util.Arrays;
import javax.xml.bind.annotation.*;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 15.12.2021
 */

/**
 * Класс содержит информацию о некотором человеке с аннотациями для сериализации/десериализации объекта.
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlAttribute
    private boolean genderMan;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private String name;
    private Contact contact;
    @XmlElementWrapper(name = "ids")
    @XmlElement(name = "id")
    private String[] ids;

    public Person() {
    }

    public Person(boolean genderMan, int age, String name, Contact contact, String... ids) {
        this.genderMan = genderMan;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.ids = ids;
    }

    public boolean isGenderMan() {
        return genderMan;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getIds() {
        return ids;
    }

    @Override
    public String toString() {
        return "Person{"
            + "genderMan=" + genderMan
            + ", age=" + age
            + ", name=" + name
            + ", contact=" + contact
            + ", ids=" + Arrays.toString(ids)
            + '}';
    }
}
