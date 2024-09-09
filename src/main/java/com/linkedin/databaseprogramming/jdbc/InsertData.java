package com.linkedin.databaseprogramming.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO students (id, name, age) VALUES (?, ?, ?)")) {

            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Max Mustermann");
            preparedStatement.setInt(3, 21);
            preparedStatement.executeUpdate();

            System.out.println("Data successfully written!");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
