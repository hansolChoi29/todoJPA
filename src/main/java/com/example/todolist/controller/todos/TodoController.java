package com.example.todolist.controller.todos;


import com.example.todolist.dto.todos.TodoCreateRequestDto;
import com.example.todolist.dto.todos.TodoSummaryDto;
import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    //페이징된 일정 조회(댓글개수 포함, 수정일 내림차순)
    @GetMapping
    public Page<TodoSummaryDto> getTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return todoService.getTodoPaged(page, size);
    }
}
