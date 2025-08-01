package com.example.todolist.repository;

import com.example.todolist.entity.TodoAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoAssignmentRepository extends JpaRepository<TodoAssignment, Long> {
    List<TodoAssignment> findByTodoId(Long todoId);
    List<TodoAssignment> findByAssignedUserId(Long userId);
    boolean existsByTodoIdAndAssignedUserId(Long todoId, Long assignedUserId);
}
