package com.spring.library.system.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "borrowers")
public class Borrowers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Email cannot be null")
    @Column(nullable = false)
    private String email;
}
