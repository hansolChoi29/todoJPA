package com.example.todolist.controller.comments;


import com.example.todolist.dto.comments.CommentCreateRequestDto;
import com.example.todolist.dto.comments.CommentResponseDto;
import com.example.todolist.dto.comments.CommentUpdateRequestDto;
import com.example.todolist.entity.Comment;
import com.example.todolist.service.CommentService;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final TodoService todoService;

    @PostMapping
    public Comment create(@RequestBody CommentCreateRequestDto requestDto){
        return commentService.createComment(
                requestDto.getTodoId(),
                requestDto.getUserName(),
                requestDto.getContent()
        );
    }
    @GetMapping("/{id}")
    public CommentResponseDto getComment(@PathVariable("id") Long commentId){
        Comment comment = commentService.getComment(commentId);
        return new CommentResponseDto(comment);
    }


    @PutMapping("/{id}")
    public CommentResponseDto updateComment(@PathVariable("id") Long commentId,
                                            @RequestBody CommentUpdateRequestDto requestDto) {
        Comment updated = commentService.updateComment(
                commentId,
                requestDto.getUserName(),
                requestDto.getContent()
        );
        return new CommentResponseDto(updated);
    }
}
