package com.library.application.dao;

import com.library.application.dto.BorrowingViewModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowingDAO {
    private final Connection connection;

    public BorrowingDAO(Connection connection) {
        this.connection = connection;
    }

    public List<BorrowingViewModel> getAllBorrowingDetails() throws SQLException {
        List<BorrowingViewModel> borrowingDetails = new ArrayList<>();
        String query = "SELECT b.BorrowID AS borrowing_id, bo.title AS book_title, m.name AS member_name, m.contact, b.BorrowDate, b.ReturnDate " +
                "FROM borrowing b " +
                "JOIN books bo ON b.BookID = bo.BookID " +
                "JOIN members m ON b.MemberID = m.MemberID";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("borrowing_id");
                String bookTitle = resultSet.getString("book_title");
                String memberName = resultSet.getString("member_name");
                String contact = resultSet.getString("contact");
                Date borrowDate = resultSet.getDate("BorrowDate");
                Date returnDate = resultSet.getDate("ReturnDate");

                BorrowingViewModel borrowing = new BorrowingViewModel(id, bookTitle, memberName, contact, borrowDate, returnDate);
                borrowingDetails.add(borrowing);
            }
        }
        return borrowingDetails;
    }
}
