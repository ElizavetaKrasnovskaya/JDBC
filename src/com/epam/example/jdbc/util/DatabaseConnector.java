package com.epam.example.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/autopark?serverTimezone=Europe/Minsk";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public static Connection getConnection() {
        return connection;
    }

    public void startConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
