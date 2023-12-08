package com.example.hospitalappointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Dbmscon {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hap";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "sugi";

    // Establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
    }

    // Close the database connection
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertDoctor(String myusername, String mypassword) {

        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO doctors (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, myusername);
                preparedStatement.setString(2, mypassword);
                preparedStatement.executeUpdate();
                System.out.println("User Created.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertPatient(String myusername, String mypassword) {

        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO patients (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, myusername);
                preparedStatement.setString(2, mypassword);
                preparedStatement.executeUpdate();
                System.out.println("User Created.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertDoctor(String name, String passText, String desText, String spcText, String mobText) {
        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO doctor (name, password,designation,specialization,mobile) VALUES (?, ? , ? , ? , ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, passText);
                preparedStatement.setString(3, desText);
                preparedStatement.setString(4, spcText);
                preparedStatement.setString(5, mobText);
                preparedStatement.executeUpdate();
                System.out.println("User Created.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertappointment(String unameText, String name2Text, String dateText, String timeText) {
        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO appointment (docname, patitentname,date,time) VALUES (?, ? , ? , ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, unameText);
                preparedStatement.setString(2, name2Text);
                preparedStatement.setString(3, dateText);
                preparedStatement.setString(4, timeText);
                preparedStatement.executeUpdate();
                System.out.println("Appointment Added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertPatient(String name1, String pass1Text, String mob1Text) {
        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO patient (name, password,mobile) VALUES (?, ? , ? )";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, name1);
                preparedStatement.setString(2, pass1Text);
                preparedStatement.setString(3, mob1Text);
                preparedStatement.executeUpdate();
                System.out.println("User Added!.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
