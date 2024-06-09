package com.library.application.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.library.application.dao.BorrowingDAO;
import com.library.application.dao.DatabaseManager;
import com.library.application.dto.BorrowingViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BorrowingController {
    @FXML
    private TableView<BorrowingViewModel> borrowingTable;
    @FXML
    private TableColumn<BorrowingViewModel, Integer> borrowingIdColumn;
    @FXML
    private TableColumn<BorrowingViewModel, String> bookTitleColumn;
    @FXML
    private TableColumn<BorrowingViewModel, String> memberNameColumn;
    @FXML
    private TableColumn<BorrowingViewModel, String> contactColumn;
    @FXML
    private TableColumn<BorrowingViewModel, LocalDate> borrowDateColumn;
    @FXML
    private TableColumn<BorrowingViewModel, LocalDate> returnDateColumn;

    private final BorrowingDAO borrowingDAO;

    public BorrowingController() {
        this.borrowingDAO = new BorrowingDAO(DatabaseManager.getConnection());
    }

    @FXML
    private void initialize() {
        borrowingIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        borrowDateColumn.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));

        loadBorrowingDetails();
    }

    private void loadBorrowingDetails() {
        try {
            List<BorrowingViewModel> borrowingDetails = borrowingDAO.getAllBorrowingDetails();
            ObservableList<BorrowingViewModel> data = FXCollections.observableArrayList(borrowingDetails);
            borrowingTable.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQLException appropriately (e.g., show an error message to the user)
        }
    }
}
