package ru.job4j.spammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 19.09.2022
 */

/**
 * Класс реализует выполнения параметризованных SQL-запросов через объект типа PreparedStatement.
 */
public class ImportDB {

    private final Properties cfg;
    private final String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * Метод выполняет чтение данных из файла в список пользователей
     */
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(line -> {
                String[] strings = line.split(";");
                if (strings.length != 2
                    || Arrays.stream(strings).anyMatch(String::isBlank)
                    || !strings[1].contains("@")
                ) {

                    throw new IllegalArgumentException("Incorrect data in line");
                }
                users.add(new User(strings[0], strings[1]));
            });
        }
        return users;
    }

    /**
     * Метод устанавливает подключение к БД и выполняет в нее SQL-запрос с параметрами для записи данных
     */
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
            cfg.getProperty("jdbc.url"),
            cfg.getProperty("jdbc.username"),
            cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users(name, email) values (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("importDB.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "chapter_007/src/data/dump.txt");
        db.save(db.load());
    }
}
