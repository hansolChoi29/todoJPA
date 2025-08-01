package com.example.todolist.service;


import com.example.todolist.entity.Comment;
import com.example.todolist.entity.Todo;
import com.example.todolist.entity.User;
import com.example.todolist.repository.CommentRepository;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class
CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public Comment createComment(Long todoId, Long userId, String content) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다."));

        User author = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("작성자 유저가 없습니다."));
        Comment comment = new Comment(todo, author, content);
        return commentRepository.save(comment);
    }


    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 댓글이 없습니다."));
    }


    public Comment updateComment(Long commentId, String content) {
        Comment comment=getComment(commentId);
        comment.update(content);
        return commentRepository.save(comment);

    }

    public void deleteComment(Long commentId) {
        Comment comment=getComment(commentId);
        commentRepository.delete(comment);
    }

    //전체조회
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }


}
