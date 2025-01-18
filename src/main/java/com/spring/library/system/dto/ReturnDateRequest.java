package com.spring.library.system.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ReturnDateRequest {

    @NotNull(message = "Return date cannot be null")
    @Column(nullable = false)
    private LocalDateTime returnDate;

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}

