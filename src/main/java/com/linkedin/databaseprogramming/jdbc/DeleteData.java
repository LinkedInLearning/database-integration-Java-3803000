package com.linkedin.databaseprogramming.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test");
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students where id = ?")) {

            preparedStatement.setInt(1, 1);
            int deletedRows = preparedStatement.executeUpdate();

            System.out.println(deletedRows + " rows deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
