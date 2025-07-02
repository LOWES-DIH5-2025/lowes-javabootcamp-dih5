package com.labs.java.jdbc;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        // logic to connect to postgres
        // STEP 1: Load the driver
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load driver: " + e.getMessage());
            return;
        }
        try {
            // STEP 2: Create a connection
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/training",
                    "postgres",
                    "postgres"
            );
            System.out.println("Connection established successfully.");
            System.out.println("Connection details: " + con.toString());

        // STEP 3: Create a statement
        stmt = con.createStatement();
        // STEP 4: Execute the query
        rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
        System.out.println("Query executed successfully.");
        System.out.println("ResultSet details: " + rs.toString());
        // STEP 5: Process the result set
        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String city = rs.getString("CITY");
            double rating = rs.getDouble("RATING");
            boolean isActive = rs.getBoolean("ACTIVE");
            System.out.printf("ID: %d, Name: %s, City: %s, Rating: %.2f, Active: %s%n", id, name, city, rating, isActive);
        }

        }catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
        }finally {
            // STEP 6: Close the connection
            try {
                rs.close();
                stmt.close();
                con.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

    }
}
