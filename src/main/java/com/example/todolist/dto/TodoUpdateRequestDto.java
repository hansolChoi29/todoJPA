package com.example.todolist.dto;

import lombok.Getter;

@Getter
// 일정 수정 시 받는 값
public class TodoUpdateRequestDto {
    private String title;
    private String content;
    private String userName;
}
