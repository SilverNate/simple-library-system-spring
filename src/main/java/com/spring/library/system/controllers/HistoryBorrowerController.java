package com.spring.library.system.controllers;

import com.spring.library.system.dto.HistoryBorrowerRequest;
import com.spring.library.system.dto.ReturnDateRequest;
import com.spring.library.system.models.Books;
import com.spring.library.system.models.Borrowers;
import com.spring.library.system.models.HistoryBorrowers;
import com.spring.library.system.services.BookService;
import com.spring.library.system.services.BorrowerService;
import com.spring.library.system.services.HistoryBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/borrow_history")
public class HistoryBorrowerController {

    @Autowired
    private HistoryBorrowerService historyBorrowerService;

    @Autowired
    private BorrowerService borrowerService;

    @Autowired
    private BookService booksService;

    @GetMapping("/overdue")
    public ResponseEntity<?> getOverdueBooks() {
        List<HistoryBorrowers> overdueBooks = historyBorrowerService.getOverdueBooks();
        if (overdueBooks.isEmpty()) {
            return ResponseEntity.ok().body(
                    new ResponseFormat(200, "No overdue books found", "OK", null)
            );
        }

        List<Object> data = overdueBooks.stream().map(history -> {
            return new Object() {
                public final Long id = history.getId();
                public final Long bookId = history.getBook().getId();
                public final Long borrowerId = history.getBorrower().getId();
                public final String borrowDate = history.getBorrowDate().toString();
                public final String dueDate = history.getDueDate().toString();
                public final String status = history.getStatus();
            };
        }).collect(Collectors.toList());

        return ResponseEntity.ok().body(
                new ResponseFormat(200, "Get overdue books successfully", "OK", data)
        );
    }

    @PostMapping
    public ResponseEntity<?> createHistory(@Valid @RequestBody HistoryBorrowerRequest request) {
        Borrowers borrower = borrowerService.getBorrowerById(request.getBorrowerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid borrower ID"));

        Books book = booksService.getBookById(request.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

        HistoryBorrowers history = new HistoryBorrowers();
        history.setBorrower(borrower);
        history.setBook(book);
        history.setBorrowDate(LocalDateTime.now());
        history.setDueDate(request.getDueDate());
        history.setStatus("on time");

        HistoryBorrowers savedHistory = historyBorrowerService.saveHistoryRecord(history);
        return ResponseEntity.ok(savedHistory);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<?> updateReturnDate(@PathVariable("id") Long id, @RequestBody @Valid ReturnDateRequest returnDateRequest) {
        try {
            HistoryBorrowers updatedHistory = historyBorrowerService.updateReturnDate(id, returnDateRequest.getReturnDate());
            return ResponseEntity.ok(new ResponseFormat(200, "Book return date updated successfully", "OK", updatedHistory));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseFormat(500, "Error updating return date", "Error", null));
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllHistoryBorrowers() {
        List<HistoryBorrowers> historyBorrowers = historyBorrowerService.getAllHistoryBorrowers();
        if (historyBorrowers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(
                new ResponseFormat(200, "Get all history borrower successfully", "OK", historyBorrowers)
        );
    }
}
