package com.example.todolist.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedAt;

    public Comment(Todo todo, String userName, String content) {
        this.todo=todo;
        this.userName =userName;
        this.content=content;
    }

    public Comment(String userName , String content) {
    }

    public void updateContent(String content) {
        this.content=content;
    }
}
