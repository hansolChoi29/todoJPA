package com.example.todolist.controller.users;


import com.example.todolist.dto.users.UserCreateRequestDto;
import com.example.todolist.dto.users.UserResponsedto;
import com.example.todolist.entity.User;
import com.example.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponsedto create(@RequestBody UserCreateRequestDto dto){
        User user=userService.createUser(dto);
        return new UserResponsedto(user);
    }
    @GetMapping("/{id}")
    public UserResponsedto get(@PathVariable Long id){
        return new UserResponsedto(userService.getUser(id));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
