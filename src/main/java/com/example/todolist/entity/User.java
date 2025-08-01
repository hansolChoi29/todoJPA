package com.example.todolist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Table(name="users")
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="user_name", nullable = false)
    private String userName;

    @Column( nullable = false )
    private String email;

    @Column(name = "create_at")
    private LocalDateTime  createDate;
    @Column(name = "modified_at")
    private LocalDateTime  modifiedAt;


    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    @PrePersist
    public void prePersist() {
        LocalDate now = LocalDate.from(LocalDateTime.now());
        this.createDate = now.atStartOfDay();
        this.modifiedAt = now.atStartOfDay();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedAt=LocalDateTime.from(LocalDateTime.now());
    }
}
