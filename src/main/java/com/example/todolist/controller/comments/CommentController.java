package com.example.todolist.controller.comments;


import com.example.todolist.dto.comments.CommentCreateRequestDto;
import com.example.todolist.dto.comments.CommentResponseDto;
import com.example.todolist.dto.comments.CommentUpdateRequestDto;
import com.example.todolist.entity.Comment;
import com.example.todolist.repository.CommentRepository;
import com.example.todolist.service.CommentService;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final TodoService todoService;

    @PostMapping
    public CommentResponseDto  create(@RequestBody CommentCreateRequestDto requestDto){
        Comment comment = commentService.createComment(
                requestDto.getTodoId(),
                requestDto.getUserId(),
                requestDto.getContent()
        );
        return new CommentResponseDto(comment);
    }
    @GetMapping("/{id}")
    public CommentResponseDto getComment(@PathVariable("id") Long commentId){
        Comment comment = commentService.getComment(commentId);
        return new CommentResponseDto(comment);
    }

    //전체 조회
    @GetMapping
    public List<CommentResponseDto> getAllComments() {
        return commentService.getAllComments().stream()
                .map(CommentResponseDto::new)
                .toList();
    }



    @PutMapping("/{id}")
    public CommentResponseDto updateComment(@PathVariable("id") Long commentId,
                                            @RequestBody CommentUpdateRequestDto requestDto) {
        Comment updated = commentService.updateComment(
                commentId,
                requestDto.getContent()
        );
        return new CommentResponseDto(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") Long commentId) {
        commentService.deleteComment(commentId);
    }
}
