package com.linkedin.databaseprogramming.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test");
             Statement statement = connection.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(255), age INT)";
            statement.execute(createTableSQL);
            System.out.println("Table 'students' successfully created!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
