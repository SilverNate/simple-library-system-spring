package com.spring.library.system.controllers;

import com.spring.library.system.models.Books;
import com.spring.library.system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService  booksService;

    // Endpoint to add a new book
    @PostMapping
    public ResponseEntity<?> addBook(@Valid @RequestBody Books books) {
        Books savedBook = booksService.saveBook(books);

        return ResponseEntity.ok().body(
                new ResponseFormat(200, "Book added successfully", "OK", savedBook)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Long id) {
        return booksService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
