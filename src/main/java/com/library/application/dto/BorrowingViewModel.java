package com.library.application.dto;

import java.sql.Date;

public class BorrowingViewModel {
    private int id;
    private String bookTitle;
    private String memberName;
    private String contact;
    private Date borrowDate;
    private Date returnDate;

    public BorrowingViewModel(int id, String bookTitle, String memberName, String contact, Date borrowDate, Date returnDate) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.memberName = memberName;
        this.contact = contact;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getBookTitle() { return bookTitle; }
    public String getMemberName() { return memberName; }
    public String getContact() { return contact; }
    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }

    public void setId(int id) { this.id = id; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public void setContact(String contact) { this.contact = contact; }
    public void setBorrowDate(Date borrowDate) { this.borrowDate = borrowDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }
}
