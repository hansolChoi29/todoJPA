package com.example.todolist.service;


import com.example.todolist.dto.users.UserCreateRequestDto;
import com.example.todolist.entity.TodoAssignment;
import com.example.todolist.entity.User;
import com.example.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserCreateRequestDto dto) {
        User user = new User(dto.getUserName(), dto.getEmail());
        return  userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 유저가 없습니다."));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
