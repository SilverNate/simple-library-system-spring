package com.spring.library.system.controllers;

import com.spring.library.system.models.Borrowers;
import com.spring.library.system.services.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @GetMapping
    public ResponseEntity<?> getAllBorrowers() {
        List<Borrowers> borrowers = borrowerService.getAllBorrowers();
        return ResponseEntity.ok().body(
                new ResponseFormat(200, "Get all borrowers successfully", "OK", borrowers));
    }

    @PostMapping
    public ResponseEntity<?> addBorrower(@RequestBody Borrowers borrower) {
        Borrowers savedBorrower = borrowerService.saveBorrower(borrower);
        return ResponseEntity.ok().body(
                new ResponseFormat(200, "Borrower added successfully", "OK", savedBorrower));
    }
}
