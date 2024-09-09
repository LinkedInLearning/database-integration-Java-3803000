package com.linkedin.databaseprogramming.jdbc.challenge;

import java.sql.*;

public class SolutionCourse {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test");
             Statement statement = connection.createStatement()) {

            String createTableSQL =
                    "CREATE TABLE IF NOT EXISTS courses (course_id INT PRIMARY KEY, course_name VARCHAR(255), duration_hours INT)";
            statement.execute(createTableSQL);

            String insertSQL = "INSERT INTO courses (course_id, course_name, duration_hours) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, "Java Grundlagen");
                preparedStatement.setInt(3, 4);
                preparedStatement.executeUpdate();

                preparedStatement.setInt(1, 2);
                preparedStatement.setString(2, "Datenbankdesign");
                preparedStatement.setInt(3, 2);
                preparedStatement.executeUpdate();

                preparedStatement.setInt(1, 3);
                preparedStatement.setString(2, "AI Programmierung");
                preparedStatement.setInt(3, 3);
                preparedStatement.executeUpdate();
            }

            String selectSQL = "SELECT * FROM courses WHERE duration_hours > 2";
            ResultSet rs = statement.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println("Kursname:" + rs.getString("course_name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
