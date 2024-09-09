package com.linkedin.databaseprogramming.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectingToH2Database {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:h2:./test";

        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            System.out.println("Connection successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
