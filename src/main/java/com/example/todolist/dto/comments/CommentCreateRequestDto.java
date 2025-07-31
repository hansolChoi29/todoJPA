package com.example.todolist.dto.comments;

import com.example.todolist.entity.Todo;
import lombok.Getter;

@Getter
public class CommentCreateRequestDto {
    private Long todoId;
    private String userName;
    private String content;
}
