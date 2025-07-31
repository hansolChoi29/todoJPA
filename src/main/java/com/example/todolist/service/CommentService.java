package com.example.todolist.service;


import com.example.todolist.entity.Comment;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.CommentRepository;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class
CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    public Comment createComment(Long todoId, String userName , String content) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다."));
        Comment comment = new Comment(todo, userName , content);
        return commentRepository.save(comment);
    }
}
