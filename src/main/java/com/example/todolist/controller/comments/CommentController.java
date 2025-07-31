package com.example.todolist.controller.comments;


import com.example.todolist.dto.comments.CommentCreateRequestDto;
import com.example.todolist.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public Coments create(@RequestBody CommentCreateRequestDto requestDto){
        return commentService.createComment(
                requestDto.getUser_name(),
                requestDto.getContent(),
                requestDto.getTodo()
        );
    }
}
