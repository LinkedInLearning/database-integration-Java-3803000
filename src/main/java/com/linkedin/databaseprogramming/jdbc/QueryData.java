package com.linkedin.databaseprogramming.jdbc;

import java.sql.*;

public class QueryData {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test");
        Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
