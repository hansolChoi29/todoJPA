package com.example.todolist.repository;

import com.example.todolist.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {


    @Query("SELECT c.todo.id, COUNT(c) FROM Comment c WHERE c.todo.id IN :ids GROUP BY c.todo.id")

    List<Object[]> countCommentsByTodoIds(@Param("ids") List<Long> ids);
}
