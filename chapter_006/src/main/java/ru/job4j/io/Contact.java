package ru.job4j.io;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 15.12.2021
 */

/**
 * Класс реализует модель с аннотациями для сериализации/десериализации объекта.
 */
@XmlRootElement(name = "contact")
public class Contact {
    @XmlAttribute
    private int zipCode;
    @XmlAttribute
    private String phone;

    public Contact() {
    }

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
            + "zipCode=" + zipCode
            + ", phone='" + phone + '\''
            + '}';
    }

    /*public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");

         Запись объекта во временный файл, который удалится системой
        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos =
                 new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }

         Чтение объекта из файла
        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ois =
                 new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
        }
    }*/
}
