package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/medical"; // Change to your actual database name
    private static String jdbcUsername = "root"; // Your MySQL username
    private static String jdbcPassword = "root"; // Your MySQL password

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error connecting to database.");
        }
        return connection;
    }
}
