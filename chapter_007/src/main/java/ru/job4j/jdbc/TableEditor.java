package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 11.09.2022
 */

/**
 * Класс реализует исполнение различных операций с данными и таблицами в БД.
 */
public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    /**
     * Метод устанавливает подключение к БД
     */
    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    /**
     * Метод создает пустую таблицу без столбцов с указанным именем
     */
    public void createTable(String tableName) throws Exception {
        String sql = String.format("create table if not exists %s();", tableName);
        statementExecute(sql, tableName);
    }

    /**
     * Метод удаляет таблицу по указанному имени
     */
    public void dropTable(String tableName) throws Exception {
        String sql = String.format("drop table if exists %s;", tableName);
        statementExecute(sql, tableName);
    }

    /**
     * Метод добавляет столбец в таблицу
     */
    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sql = String.format(
            "alter table if exists %s add column if not exists %s %s;",
            tableName, columnName, type
        );
        statementExecute(sql, tableName);
    }

    /**
     * Метод удаляет столбец из таблицы
     */
    public void dropColumn(String tableName, String columnName) throws Exception {
        String sql = String.format(
            "alter table if exists %s drop column if exists %s;",
            tableName, columnName
        );
        statementExecute(sql, tableName);
    }

    /**
     * Метод переименовывает столбец
     */
    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String sql = String.format(
            "alter table if exists %s rename column %s to %s;",
            tableName, columnName, newColumnName
        );
        statementExecute(sql, tableName);
    }

    /**
     * Метод выполняет SQL-запрос в БД
     */
    private void statementExecute(String sql, String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                    metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
        }
        TableEditor tableEditor = new TableEditor(config);
        try (Connection connection = tableEditor.connection) {
            String tableName = "demo_table";
            tableEditor.createTable(tableName);
            System.out.println(getTableScheme(connection, "demo_table"));
            tableEditor.addColumn(tableName, "id", "serial primary key");
            tableEditor.addColumn(tableName, "test_name", "varchar(255)");
            System.out.println(getTableScheme(connection, "demo_table"));
            tableEditor.renameColumn(tableName, "test_name", "test_name_new");
            System.out.println(getTableScheme(connection, "demo_table"));
            tableEditor.dropColumn(tableName, "test_name_new");
            System.out.println(getTableScheme(connection, "demo_table"));
            tableEditor.dropTable(tableName);
        } finally {
            System.out.println("isClosedConnection: " + tableEditor.connection.isClosed());
        }
    }
}
