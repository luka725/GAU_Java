package com.library.application.dao;

import java.sql.*;

public class DatabaseManager {
    private static final String url = "jdbc:sqlserver://DESKTOP-4QOVIBN\\SQLEXPRESS:53994;DatabaseName=Library;user=library;encrypt=false;";
    private static Connection connection;

    // Private constructor to prevent instantiation from outside
    private DatabaseManager() {}

    // Method to get the singleton instance of DatabaseManager
    public static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }

    // Method to close the database connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                connection = null; // Reset connection to null after closing
            }
        }
    }
}
