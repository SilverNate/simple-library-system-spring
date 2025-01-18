package com.spring.library.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.library.system.repositories.HistoryBorrowerRepository;
import com.spring.library.system.models.HistoryBorrowers;
import java.util.List;
import java.time.LocalDateTime;


@Service
public class HistoryBorrowerService {
    @Autowired
    private HistoryBorrowerRepository historyBorrowerRepository;

    public List<HistoryBorrowers> getOverdueBooks() {
        return historyBorrowerRepository.findOverdueBooks();
    }

    public HistoryBorrowers saveHistoryRecord(HistoryBorrowers historyBorrower) {
        return historyBorrowerRepository.save(historyBorrower);
    }

    public HistoryBorrowers updateReturnDate(Long id, LocalDateTime returnDate) {
        HistoryBorrowers history = historyBorrowerRepository.findById(id).orElseThrow(() -> new RuntimeException("History not found"));

        history.setReturnDate(returnDate);

        LocalDateTime dueDate = history.getDueDate();
        if (returnDate != null && returnDate.isAfter(dueDate)) {
            history.setStatus("late");
        } else {
            history.setStatus("on time");
        }

        return historyBorrowerRepository.save(history);
    }

    public List<HistoryBorrowers> getAllHistoryBorrowers() {
        return historyBorrowerRepository.findAll();
    }
}