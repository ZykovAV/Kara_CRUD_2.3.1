package ru.zykov.springcourse.connect_db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.zykov.springcourse.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;
    private static SessionFactory factory = null;

    public static Connection openConnection() {
        try {
            if (connection != null && !connection.isClosed()) { return connection; }

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        if (factory != null) { factory.close(); }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static SessionFactory getFactory() {
        if (factory == null) {
            return factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return factory;

    }
}
