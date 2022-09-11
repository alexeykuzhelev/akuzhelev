package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 02.08.2022
 */

/**
 * Класс реализует чтение файла конфигурации, чтобы получить данные для подключения к БД.
 * Устанавливает подключение к БД и получает данные о подключении, такие как имя пользователя и url.
 */
public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Config config = new Config("./chapter_007/src/main/resources/app.properties");
        config.load();
        Class.forName(config.value("driver"));
        String url = config.value("url");
        String login = config.value("login");
        String password = config.value("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
