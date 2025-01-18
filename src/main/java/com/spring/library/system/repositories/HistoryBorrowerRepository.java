package com.spring.library.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.library.system.models.HistoryBorrowers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryBorrowerRepository extends JpaRepository<HistoryBorrowers, Long> {
    @Query("SELECT h FROM HistoryBorrowers h WHERE h.returnDate IS NULL AND h.dueDate < CURRENT_TIMESTAMP")
    List<HistoryBorrowers> findOverdueBooks();
}
