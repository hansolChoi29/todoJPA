package com.example.todolist.dto.todos;


import com.example.todolist.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSummaryDto {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String createdDate;
    private String modifiedAt;
    private long commentCount;

    public TodoSummaryDto(Todo todo, long commentCount) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.userName = todo.getUserName();
        this.createdDate = todo.getCreatedDate() == null ? null : todo.getCreatedDate().toString();
        this.modifiedAt = todo.getModifiedAt() == null ? null : todo.getModifiedAt().toString();
        this.commentCount = commentCount;
    }
}
