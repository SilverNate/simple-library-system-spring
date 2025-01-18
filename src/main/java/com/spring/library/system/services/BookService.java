package com.spring.library.system.services;

import com.spring.library.system.models.Books;
import com.spring.library.system.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Save Book
    public Books saveBook(Books books) {
        return bookRepository.save(books);  // Save the books to the database
    }

    public Optional<Books> getBookById(Long id) {
        return bookRepository.findById(id);
    }
}
