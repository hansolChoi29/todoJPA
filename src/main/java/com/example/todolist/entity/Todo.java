package com.example.todolist.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

//    @Column(nullable = false)
//    private String userName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedAt;

    public Todo(User owner, String title, String content) {
        this.owner = owner;
        this.title=title;
        this.content=content;
    }
    public void update(  String title, String content) {
        this.title = title;
        this.content = content;
        this.modifiedAt = LocalDateTime.now();
    }

    //엔티티의 생명주기 콜백을 넣어 null도 반환되는 문제 해결.
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now;
        this.modifiedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }

    //영속성 전이: 일정삭제 시 댓글도 같이 삭제
    //TODO: 부모-자식 관계 개념으로 접근하여 고아댓글 삭제로직
    //OneToMany: 하나의 일정에 여러 댓글이 붙는 양방향관계의 부모쪽
    //mappedBy=todo 댓글 쪽의 todo필드가 왜래키를 관리하니까. 읽기용
    //cascade = CascadeType.ALL 부모(Todo) 작업이 자식(Comment)에게 전달.
    //orpahnRemoval=true: 부모에서 분리. 고아가 된 댓글이면 제거.
    
    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments=new ArrayList<>();
}
