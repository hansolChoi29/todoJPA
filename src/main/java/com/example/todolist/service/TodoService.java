package com.example.todolist.service;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoService{
    private final TodoRepository todoRepository;

    public Todo createTodo(String userName, String title, String content) {
        Todo todo = new Todo(userName, title, content);
        return todoRepository.save(todo);
    }

    public Todo getTodo(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 없습니다."));
    }

    public Todo updateTodo(Long id,String userName, String title, String content) {
        Todo todo = getTodo(id); // 재사용
        todo.update(userName,title, content);
        return todoRepository.save(todo);
    }

}
