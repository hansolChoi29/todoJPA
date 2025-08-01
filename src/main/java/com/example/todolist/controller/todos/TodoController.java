package com.example.todolist.controller.todos;


import com.example.todolist.dto.todos.TodoCreateRequestDto;
import com.example.todolist.dto.todos.TodoResponseDto;
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
                requestDto.getOwnerId(),
                requestDto.getTitle(),
                requestDto.getContent(), requestDto.getAssigneeIds()
        );
    }

    @GetMapping("/{id}")
    public TodoResponseDto getTodo(@PathVariable Long id) {
        Todo todo = todoService.getTodo(id);
        return new TodoResponseDto(todo);
    }

    @PutMapping("/{id}")
    public TodoResponseDto updatetodo(@PathVariable Long id, @RequestBody TodoCreateRequestDto requestDto) {
        Todo updated = todoService.updateTodo(
                id,
                requestDto.getOwnerId(),
                requestDto.getTitle(),
                requestDto.getContent()
        );
        return new TodoResponseDto(updated);
    }

    //페이징된 일정 조회(댓글개수 포함, 수정일 내림차순)
    @GetMapping
    public Page<TodoSummaryDto> getTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return todoService.getTodoPaged(page, size);
    }


    //영속성 전이: 삭제 엔드포인트

    //신기한게, 댓글에 영속성 언급 안해줬는데 같이 삭제됨
    // JPA 내부에서 Comment객체 cascade설정 때문에 함께 삭제 대상이 됨.

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
    // todo DeleteMapping을 안만들어줬던 이유가
    // todo삭제 시 commnet도 삭제되게 만들려는 의도였음

}
