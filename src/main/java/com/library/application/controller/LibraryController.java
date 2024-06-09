package com.library.application.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.library.application.dao.BookDAO;
import com.library.application.dao.BorrowingDAO;
import com.library.application.dao.DatabaseManager;
import com.library.application.dto.Book;
import com.library.application.dto.BorrowingViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class LibraryController {
    @FXML
    private TableView<Book> booksTable;
    @FXML
    private TableColumn<Book, Integer> bookIdColumn;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> publisherColumn;
    @FXML
    private TableColumn<Book, String> genreColumn;
    @FXML
    private TableColumn<Book, Boolean> availableColumn;

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
    private TableColumn<BorrowingViewModel, String> borrowDateColumn;
    @FXML
    private TableColumn<BorrowingViewModel, String> returnDateColumn;

    @FXML
    private TextField searchField;

    @FXML
    private TextField borrowingSearchField;

    private final BookDAO bookDAO;
    private final BorrowingDAO borrowingDAO;

    private ObservableList<Book> bookData;

    private ObservableList<BorrowingViewModel> BorrowingData;

    public LibraryController() {
        this.bookDAO = new BookDAO(DatabaseManager.getConnection());
        this.borrowingDAO = new BorrowingDAO(DatabaseManager.getConnection());
    }

    @FXML
    private void initialize() {
        // Initialize Books TableView
        bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));

        // Initialize Borrowing TableView
        borrowingIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        borrowDateColumn.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));

        // Load data into the tables
        loadBooks();
        loadBorrowingDetails();

        // Add listener to the search field to filter the book table
        searchField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filterBooks(newValue);
            }
        });

        borrowingSearchField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filterBorrows(newValue);
            }
        });
    }

    private void loadBooks() {
        try {
            List<Book> books = bookDAO.getAllBooks();
            bookData = FXCollections.observableArrayList(books);
            booksTable.setItems(bookData);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQLException appropriately (e.g., show an error message to the user)
        }
    }

    private void loadBorrowingDetails() {
        try {
            List<BorrowingViewModel> borrowingDetails = borrowingDAO.getAllBorrowingDetails();
            BorrowingData = FXCollections.observableArrayList(borrowingDetails);
            borrowingTable.setItems(BorrowingData);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQLException appropriately (e.g., show an error message to the user)
        }
    }

    private void filterBooks(String query) {
        if (query == null || query.isEmpty()) {
            booksTable.setItems(bookData);
        } else {
            List<Book> filteredBooks = bookData.stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                            book.getAuthor().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
            booksTable.setItems(FXCollections.observableArrayList(filteredBooks));
        }
    }

    private void filterBorrows(String query) {
        if (query == null || query.isEmpty()) {
            borrowingTable.setItems(BorrowingData);
        } else {
            List<BorrowingViewModel> filteredBorrows = BorrowingData.stream()
                    .filter(borrow -> borrow.getBookTitle().toLowerCase().contains(query.toLowerCase()) ||
                            borrow.getMemberName().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
            borrowingTable.setItems(FXCollections.observableArrayList(filteredBorrows));
        }
    }
}
