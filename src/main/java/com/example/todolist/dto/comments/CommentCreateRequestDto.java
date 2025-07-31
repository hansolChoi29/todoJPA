package com.example.todolist.dto.comments;

import com.example.todolist.entity.Todo;
import lombok.Getter;

@Getter
public class CommentCreateRequestDto {
    private Todo todo;
    private String user_name;
    private String content;
}
