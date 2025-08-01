package com.example.todolist.controller;


import com.example.todolist.dto.TodoCreateRequestDto;
import com.example.todolist.dto.TodoResponseDto;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;


    @PostMapping
    public TodoResponseDto create(@RequestBody TodoCreateRequestDto dto) {
       Todo saved=todoService.createTodo(dto.getUserName(), dto.getTitle(),dto.getContent());
       return new TodoResponseDto(saved);
    }
    @GetMapping("/{id}")
    public  TodoResponseDto getTodo(@PathVariable Long id) {
        Todo todo=todoService.getTodo(id);
        return new TodoResponseDto(todo);
    }

    @PutMapping("/{id}")
    public TodoResponseDto updatetodo(@PathVariable Long id, @RequestBody TodoCreateRequestDto requestDto) {
        Todo update=todoService.updateTodo(id, requestDto.getUserName(), requestDto.getTitle(), requestDto.getContent());
        return new TodoResponseDto(update);
    }
}
