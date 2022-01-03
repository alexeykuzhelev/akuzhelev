package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 04.01.2022
 */

/**
 * Класс реализует преобразование POJO объекта в JSONObject и json-строку.
 */
public class JSONObjectParser {

    public static void main(String[] args) {

        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"zipCode\":354000,\"phone\":\"65-06-40\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("idReport-1");
        list.add("idReport-2");
        list.add("idReport-3");
        JSONArray jsonIds = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Person person = new Person(
            true, 44, "Aleks", new Contact(354000, "65-06-40"),
            "idReport-1", "idReport-2", "idReport-3"
        );
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("genderMan", person.isGenderMan());
        jsonObject.put("age", person.getAge());
        jsonObject.put("name", person.getName());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("ids", jsonIds);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(person).toString());
    }
}
