package com.library.application.controller;

import java.sql.SQLException;
import java.util.List;

import com.library.application.dto.Book;
import com.library.application.dao.BookDAO;
import com.library.application.dao.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private TableColumn<Book, Integer> availableColumn;

    private final BookDAO bookDAO;

    public BooksController() {
        this.bookDAO = new BookDAO(DatabaseManager.getConnection());
    }

    @FXML
    private void initialize() {
        // Populate the TableView with dummy data for testing
        ObservableList<Book> data = FXCollections.observableArrayList(
                new Book(1, "Book1", "Author1", "Publisher1", "Genre1", 1),
                new Book(2, "Book2", "Author2", "Publisher2", "Genre2", 0),
                new Book(3, "Book3", "Author3", "Publisher3", "Genre3", 1)
        );
        booksTable.setItems(data);
    }

    private void loadBooks() {
        try {
            List<Book> books = bookDAO.getAllBooks();
            ObservableList<Book> data = FXCollections.observableArrayList(books);
            booksTable.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQLException appropriately (e.g., show an error message to the user)
        }
    }
    private void loadDummyBooks() {
        // Create some dummy Book objects
        Book book1 = new Book(1, "Dummy Title 1", "Dummy Author 1", "Dummy Publisher 1", "Dummy Genre 1", 1);
        Book book2 = new Book(2, "Dummy Title 2", "Dummy Author 2", "Dummy Publisher 2", "Dummy Genre 2", 0);

        // Create an ObservableList to hold the dummy data
        ObservableList<Book> dummyData = FXCollections.observableArrayList(book1, book2);

        // Set the dummy data to the TableView
        booksTable.setItems(dummyData);
    }
}
