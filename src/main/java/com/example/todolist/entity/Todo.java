package com.example.todolist.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedAt;

    public Todo(String userName, String title, String content) {
        this.userName = userName;
        this.title=title;
        this.content=content;
    }
    public void update( String userName, String title, String content) {
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.modifiedAt = LocalDateTime.now();
    }

    //엔티티의 생명주기 콜백을 넣어 null도 반환되는 문제 해결.
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now;
        this.modifiedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }
}
