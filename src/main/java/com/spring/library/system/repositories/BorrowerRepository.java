package com.spring.library.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.library.system.models.Borrowers;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrowers, Long> {
}
