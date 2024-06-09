package com.library.application.dao;
import com.library.application.dto.Borrowing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BorrowingDAO {
    private Connection connection;

    public BorrowingDAO(Connection connection) {
        this.connection = connection;
    }

    public void createBorrowing(int borrowID, int bookID, int memberID, String borrowDate, String returnDate) throws SQLException {
        String sql = "INSERT INTO Borrowing (BookID, MemberID, BorrowDate, ReturnDate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bookID);
            statement.setInt(2, memberID);
            statement.setString(3, borrowDate);
            statement.setString(4, returnDate);
            statement.executeUpdate();
        }
    }

    public void updateBorrowing(int borrowID, String returnDate) throws SQLException {
        String sql = "UPDATE Borrowing SET ReturnDate = ? WHERE BorrowID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, returnDate);
            statement.setInt(2, borrowID);
            statement.executeUpdate();
        }
    }

    public void deleteBorrowing(int borrowID) throws SQLException {
        String sql = "DELETE FROM Borrowing WHERE BorrowID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, borrowID);
            statement.executeUpdate();
        }
    }

    public List<Borrowing> getAllBorrowings() throws SQLException {
        List<Borrowing> borrowings = new ArrayList<>();
        String sql = "SELECT * FROM Borrowing";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int borrowID = resultSet.getInt("BorrowID");
                int bookID = resultSet.getInt("BookID");
                int memberID = resultSet.getInt("MemberID");
                Date borrowDate = resultSet.getDate("BorrowDate");
                Date returnDate = resultSet.getDate("ReturnDate");
                Borrowing borrowing = new Borrowing(borrowID, bookID, memberID, borrowDate, returnDate);
                borrowings.add(borrowing);
            }
        }
        return borrowings;
    }
}
