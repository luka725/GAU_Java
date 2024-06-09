package com.library.application.dto;

import java.util.Date;

public class Borrowing {
    private int borrowId;
    private int bookId;
    private int memberId;
    private Date borrowDate;
    private Date returnDate;
    public Borrowing(int borrowId, int bookId, int memberId, Date borrowDate, Date returnDate) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
}
