package com.example.todolist.service;


import com.example.todolist.entity.Comment;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@RequestMapping("/comments")
public class
CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Todo todo, String user_name, String content) {
        Comment comment = new Comment(todo,user_name, content);
        return commentRepository.save(comment);
    }
}
