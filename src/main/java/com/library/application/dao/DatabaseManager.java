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

    public static String getMemberFromDatabase(int memberId) {
        String memberName = null;
        Connection connection = null; // Avoid reassigning the class-level connection
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection
            connection = getConnection();

            // SQL query to retrieve member name based on memberId
            String sql = "SELECT Name FROM Members WHERE MemberID = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, memberId);

            // Execute the query
            resultSet = statement.executeQuery();

            // Check if a row was returned
            if (resultSet.next()) {
                // Retrieve the member name from the result set
                memberName = resultSet.getString("Name");
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
        } finally {
            // Close the result set, statement, and connection
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                // Note: Do not close the connection here; it's a singleton
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return memberName;
    }
}