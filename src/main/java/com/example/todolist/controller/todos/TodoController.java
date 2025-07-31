package com.example.todolist.controller.todos;


import com.example.todolist.dto.todos.TodoCreateRequestDto;
import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;


    @PostMapping
    public Todo create(@RequestBody TodoCreateRequestDto requestDto) {
        return todoService.createTodo(
                requestDto.getUserName(),
                requestDto.getTitle(),
                requestDto.getContent()
        );
    }
    @GetMapping("/{id}")
    public  Todo getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @PutMapping("/{id}")
    public Todo updatetodo(@PathVariable Long id, @RequestBody TodoCreateRequestDto requestDto) {
        return todoService.updateTodo(id,requestDto.getUserName(), requestDto.getTitle(), requestDto.getContent());
    }
}
