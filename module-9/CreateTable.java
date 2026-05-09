/**
 * Isaac St Hubert 05/09/2026 Module 9.2
 * This program uses the CreateTable.java example to test the database connection
 */

import java.sql.*;

public class CreateTable {

    Connection con;
    Statement stmt;

    public CreateTable() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/databasedb";

            con = DriverManager.getConnection(url, "student1", "pass");

            stmt = con.createStatement();

            System.out.println("Connected to database.");

        } catch (Exception e) {
            System.out.println("Error connecting to database.");
            e.printStackTrace();
            System.exit(0);
        }

        try {
            stmt.executeUpdate("DROP TABLE address33");
            System.out.println("Table address33 dropped.");
        } catch (SQLException e) {
            System.out.println("Table address33 does not exist.");
        }

        try {
            stmt.executeUpdate(
                "CREATE TABLE address33 (" +
                "ID INT PRIMARY KEY, " +
                "LASTNAME VARCHAR(40), " +
                "FIRSTNAME VARCHAR(40), " +
                "STREET VARCHAR(40), " +
                "CITY VARCHAR(40), " +
                "STATE VARCHAR(40), " +
                "ZIP VARCHAR(40))"
            );

            System.out.println("Table address33 created.");

        } catch (SQLException e) {
            System.out.println("Table creation failed.");
            e.printStackTrace();
        }

        try {
            stmt.close();
            con.close();
            System.out.println("Database connections closed.");

        } catch (SQLException e) {
            System.out.println("Connection close failed.");
        }
    }

    public static void main(String[] args) {
        new CreateTable();
    }
}