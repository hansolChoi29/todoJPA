package com.example.todolist.dto;


import lombok.Getter;

@Getter
public class TodoCreateRequestDto {
    private String title;
    private String content;
    private String userName;


}
