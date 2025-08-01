package com.example.todolist.dto.todos;


import lombok.Getter;

import java.util.List;

@Getter
public class TodoCreateRequestDto {
    private String title;
    private String content;
    private Long ownerId;
    private List<Long> assigneeIds;
}
