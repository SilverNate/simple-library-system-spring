package com.spring.library.system.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title cannot be null")
    @Column(nullable = false)
    private String title;

    @NotNull(message = "author cannot be null")
    @Column
    private String author;

    @NotNull(message = "Published date cannot be null")
    @Column(nullable = false)
    private LocalDateTime publishedDate;
}
