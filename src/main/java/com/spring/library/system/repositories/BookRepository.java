package com.spring.library.system.repositories;

import com.spring.library.system.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
    // JpaRepository provides basic CRUD methods
}
