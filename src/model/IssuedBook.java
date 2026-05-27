package model;

import java.time.LocalDate;

public class IssuedBook {

    private int id;
    private int userId;
    private int bookId;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private double fine;
    private String status;

    public IssuedBook() {
    }

    public IssuedBook(int id, int userId, int bookId,
                      LocalDate issueDate, LocalDate dueDate,
                      LocalDate returnDate, double fine, String status) {

        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IssuedBook{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", fine=" + fine +
                ", status='" + status + '\'' +
                '}';
    }
}
