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

    public TodoSummaryDto(Long id, String title, String content, String writer,
                          LocalDateTime createdAt, LocalDateTime modifiedAt, long commentCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.createdDate = createdAt == null ? null : createdAt.toString();
        this.modifiedAt = modifiedAt == null ? null : modifiedAt.toString();
        this.commentCount = commentCount;
    }

    public TodoSummaryDto(Todo todo, Long orDefault) {
    }
}
