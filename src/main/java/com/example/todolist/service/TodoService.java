package com.example.todolist.service;

import com.example.todolist.dto.todos.TodoSummaryDto;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.CommentRepository;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TodoService{
    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    public Todo createTodo(String userName, String title, String content) {
        Todo todo = new Todo(userName, title, content);
        return todoRepository.save(todo);
    }

    public Todo getTodo(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 없습니다."));
    }
//커밋용
    public Todo updateTodo(Long id,String userName, String title, String content) {
        Todo todo = getTodo(id); // 재사용
        todo.update(userName,title, content);
        return todoRepository.save(todo);
    }


    //페이징 조회, 수정일 내림차순, 댓글 개수 포함
    public Page<TodoSummaryDto> getTodoPaged(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "modifiedAt"));

        Page<Todo> todosPage = todoRepository.findAll(pageable);
        List<Long> todoIds = todosPage.stream()
                .map(Todo::getId)
                .toList();

        // 댓글 수를 한 번에 가져옴
        List<Object[]> rawCounts = commentRepository.countCommentsByTodoIds(todoIds);
        Map<Long, Long> countMap = rawCounts.stream()
                .collect(Collectors.toMap(
                        arr -> (Long) arr[0],
                        arr -> (Long) arr[1]
                ));

        // 엔티티를 DTO로 변환하면서 댓글 수 붙이기
        List<TodoSummaryDto> dtoList = todosPage.getContent().stream()
                .map(todo -> new TodoSummaryDto(todo, countMap.getOrDefault(todo.getId(), 0L)))
                .toList();

        return new PageImpl<>(dtoList, pageable, todosPage.getTotalElements());
    }

    // 영속성 전이: 삭제 메서드
    public void deleteTodo(Long id){
        //영속성 컨텍스트에 Todo로드
        Todo todo=getTodo(id);
        //연관 댓글 함께 삭제;(삭제 호출: cascade/all + orphanRemoval)
        todoRepository.delete(todo);
    }
}
