package com.example.todolist.dto.users;

import com.example.todolist.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponsedto {
    private Long id;
    private String userName;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedAt;

    public UserResponsedto(User user) {
        this.createdDate = user.getCreateDate()==null?LocalDateTime.now():user.getCreateDate();
        this.modifiedAt = user.getModifiedAt()==null?LocalDateTime.now():user.getModifiedAt();
        this.id=user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();

    }

}
