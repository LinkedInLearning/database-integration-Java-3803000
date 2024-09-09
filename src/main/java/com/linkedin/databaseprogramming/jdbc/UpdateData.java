package com.linkedin.databaseprogramming.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test");
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students SET name = ? WHERE id = ?")) {

            preparedStatement.setString(1, "Erika Musterfrau");
            preparedStatement.setInt(2, 1);

            int updatedRows = preparedStatement.executeUpdate();
            System.out.println("Successfully updated " + updatedRows + " rows");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
