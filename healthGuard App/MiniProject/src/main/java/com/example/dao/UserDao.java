package com.example.dao;

import com.example.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    
    public int registerUser(String email, String password) throws SQLException, ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users (email, password) VALUES (?, ?);";
        int result = 0;
        
        // Try with resources to ensure connection is closed
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
