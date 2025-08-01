package com.example.todolist.dto.todos;


import com.example.todolist.entity.User;
import lombok.Getter;

@Getter
public class AssigneeDto {
    private Long id;
    private String userName;
    private String email;

    public AssigneeDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }
}
