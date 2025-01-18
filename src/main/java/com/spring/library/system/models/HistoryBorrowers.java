package com.spring.library.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "history_borrowers")
public class HistoryBorrowers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    @NotNull(message = "Borrower cannot be null")
    private Borrowers borrower;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @NotNull(message = "Book cannot be null")
    private Books book;

    @NotNull(message = "borrowDate cannot be null")
    @Column(nullable = false)
    private LocalDateTime borrowDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime returnDate;

    @NotNull(message = "dueDate cannot be null")
    @Column(nullable = false)
    private LocalDateTime dueDate;

    @Column
    private String status;

    // Getters and setters

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
     this.status =  status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Borrowers getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrowers borrower) {
        this.borrower = borrower;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
