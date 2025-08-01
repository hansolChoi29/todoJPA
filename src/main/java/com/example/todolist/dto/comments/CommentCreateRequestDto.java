package com.example.todolist.dto.comments;

import com.example.todolist.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentCreateRequestDto {
    private Long todoId;
    private Long userId;
    private String content;
}
