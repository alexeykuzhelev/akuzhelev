package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.11.2021
 */

/**
 * Класс реализует преобразование объекта в JSON и обратно.
 */
public class JsonObjectConverting {
    public static void main(String[] args) {
        final Person person = new Person(
            true, 44, "Aleks", new Contact(354000, "65-06-40"),
            new String[] {"idReport-1", "idReport-2", "idReport-3"}
        );

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        /* Модифицируем json-строку */
        final String personJson =
            "{"
                + "\"genderMan\":true,"
                + "\"age\":44,"
                + "\"name\":\"Aleks\","
                + "\"contact\":"
                + "{"
                + "\"zipCode\":354000,"
                + "\"phone\":\"65-06-40\""
                + "},"
                + "\"ids\":"
                + "[\"idReport-1\",\"idReport-2\",\"idReport-3\"]"
                + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
