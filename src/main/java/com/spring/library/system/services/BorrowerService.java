package com.spring.library.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.library.system.repositories.BorrowerRepository;
import com.spring.library.system.models.Borrowers;
import java.util.List;
import java.util.Optional;


@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    public List<Borrowers> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public Borrowers saveBorrower(Borrowers borrower) {
        return borrowerRepository.save(borrower);
    }

    public Optional<Borrowers> getBorrowerById(Long id) {
        return borrowerRepository.findById(id);
    }
}
