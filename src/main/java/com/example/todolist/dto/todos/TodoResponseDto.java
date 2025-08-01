package com.example.todolist.dto.todos;


import com.example.todolist.entity.Todo;
import lombok.Getter;

@Getter
//단건 조회, 생성 응답, 수정응답에 쓰이는 DTO
public class TodoResponseDto {
    private Long id;
    private String title;
    private String content;
    private String ownerName;
    private String createdDate;
    private String modifiedAt;

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.ownerName = todo.getOwner().getUserName();
        this.createdDate = todo.getCreatedDate() == null ? null : todo.getCreatedDate().toString();
        this.modifiedAt = todo.getModifiedAt() == null ? null : todo.getModifiedAt().toString();
    }
}
