package com.library.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    private static final String URL = "jdbc:sqlserver://DESKTOP-4QOVIBN\\SQLEXPRESS:53994;DatabaseName=Library;user=library;encrypt=false;";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static String getMemberFromDatabase(int memberId) {
        String memberName = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection
            connection = DriverManager.getConnection(URL);

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
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return memberName;
    }
}
