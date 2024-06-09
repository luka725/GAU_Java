package com.library.application.dto;

import java.time.LocalDate;

public class Borrowing {
    private int id;
    private int bookID;
    private int memberID;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Borrowing(int id, int bookID, int memberID, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.bookID = bookID;
        this.memberID = memberID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and setters
    // ...
}
