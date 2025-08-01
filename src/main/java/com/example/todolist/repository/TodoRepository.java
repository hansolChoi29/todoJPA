package com.example.todolist.repository;

import com.example.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query("""
        SELECT t FROM Todo t
        LEFT JOIN FETCH t.owner o
        LEFT JOIN FETCH t.assignments a
        LEFT JOIN FETCH a.assignedUser u
        WHERE t.id = :id
        """)
    Optional<Todo> findByIdWithAssignees(@Param("id") Long id);
}
