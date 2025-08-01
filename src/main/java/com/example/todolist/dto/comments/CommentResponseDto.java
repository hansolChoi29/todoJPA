package com.example.todolist.dto.comments;


import com.example.todolist.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private final String modifiedAt;
    private Long id;
    private TodoDto todo;
    private String userName;
    private String content;
    private String createdDate;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.todo = new TodoDto(comment.getTodo());
        this.userName = comment.getUserName();
        this.content = comment.getContent();
        this.createdDate = comment.getCreatedDate() == null ? null : comment.getCreatedDate().toString();
        this.modifiedAt = comment.getModifiedAt() == null ? null : comment.getModifiedAt().toString();
    }


    @Getter
    public static class TodoDto {
        private Long id;
        private String userName;
        private String title;
        private String content;
        private String createdDate;
        private String modifiedAt;

        public TodoDto(com.example.todolist.entity.Todo todo) {
            this.id = todo.getId();
            this.userName = todo.getUserName();
            this.title = todo.getTitle();
            this.content = todo.getContent();
            this.createdDate = todo.getCreatedDate() == null ? null : todo.getCreatedDate().toString();
            this.modifiedAt = todo.getModifiedAt() == null ? null : todo.getModifiedAt().toString();
        }
    }
}
