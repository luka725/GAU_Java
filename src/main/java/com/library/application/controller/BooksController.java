package com.library.application.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.library.application.dto.Book;
import com.library.application.dao.BookDAO;
import com.library.application.dao.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BooksController {
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
    private TextField searchField;

    private final BookDAO bookDAO;
    private ObservableList<Book> bookData;

    public BooksController() {
        this.bookDAO = new BookDAO(DatabaseManager.getConnection());
    }

    @FXML
    private void initialize() {
        // Initialize the columns
        bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));

        // Load books when the controller is initialized
        loadBooks();

        // Add listener for search field
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterBooks(newValue));
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

    private void filterBooks(String query) {
        if (query == null || query.isEmpty()) {
            booksTable.setItems(bookData);
        } else {
            String lowerCaseQuery = query.toLowerCase();
            ObservableList<Book> filteredBooks = bookData.stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(lowerCaseQuery) ||
                            book.getAuthor().toLowerCase().contains(lowerCaseQuery) ||
                            book.getPublisher().toLowerCase().contains(lowerCaseQuery) ||
                            book.getGenre().toLowerCase().contains(lowerCaseQuery))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            booksTable.setItems(filteredBooks);
        }
    }
}
