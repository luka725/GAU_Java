package com.library.application.dao;

import com.library.application.dto.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDAO {
    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    public void createBook(String title, String author, String publisher, String genre, int available) throws SQLException {
        String sql = "INSERT INTO Books (Title, Author, Publisher, Genre, Available) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, publisher);
            statement.setString(4, genre);
            statement.setInt(5, available);
            statement.executeUpdate();
        }
    }

    public void updateBook(int bookID, boolean available) throws SQLException {
        String sql = "UPDATE Books SET Available = ? WHERE BookID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, available);
            statement.setInt(2, bookID);
            statement.executeUpdate();
        }
    }

    public void deleteBook(int bookID) throws SQLException {
        String sql = "DELETE FROM Books WHERE BookID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bookID);
            statement.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Books";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int bookId = resultSet.getInt("BookID");
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");
                String publisher = resultSet.getString("Publisher");
                String genre = resultSet.getString("Genre");
                int available = resultSet.getInt("Available");
                Book book = new Book(bookId, title, author, publisher, genre, available);
                books.add(book);
            }
        }
        return books;
    }

}
