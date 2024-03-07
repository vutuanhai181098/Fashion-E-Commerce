package com.example.ecommerce.entity;

import com.example.ecommerce.constant.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(15)")
    private String phone;

    @Column(columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean isEnabled;

    private boolean isLocked;

    private LocalDateTime unLockTime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @PrePersist
    void prePersist() {
        isEnabled = false;
        isLocked = false;
        createdAt = LocalDateTime.now();
    }
}
