package com.spring.library.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryBorrowerRequest {

    @NotNull(message = "Borrower ID cannot be null")
    private Long borrowerId;

    @NotNull(message = "Book ID cannot be null")
    private Long bookId;

    @NotNull(message = "due date cannot be null")
    private LocalDateTime dueDate;
}
