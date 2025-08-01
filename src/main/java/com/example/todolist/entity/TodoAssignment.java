package com.example.todolist.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "todo_assignments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"todo_id", "user_id"})
})
@Entity
@Getter
@NoArgsConstructor
public class TodoAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime assignedAt=LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User assignedUser;

    public TodoAssignment(Todo todo, User assignedUser) {
        this.todo=todo;
        this.assignedUser=assignedUser;
    }


}
