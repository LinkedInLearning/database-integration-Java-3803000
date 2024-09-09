package com.linkedin.databaseprogramming.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactions {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test")) {

            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("INSERT INTO students (id, name, age) VALUES (9, 'Hans Meier', 23)");
                statement.executeUpdate("INSERT INTO students (id, name, age) VALUES (3, 'Anna Schmidt', 20)");
                connection.commit();

                System.out.println("Transaction successful");

            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Transaction failure, rollback");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
