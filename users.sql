USE todo;
 CREATE TABLE users(
     id BIGINT  AUTO_INCREMENT PRIMARY KEY,
     userName VARCHAR(50) NOT NULL,
     email VARCHAR(50) NOT NULL,
     create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
     modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

);

# 일정은 여러명이 맡을 수 있고 유저 한 명은 여러 일정을 맡을 수 있다. N:M관계
# todo=프로젝트, user=사람 todo_assignments=사람을 프로젝트에 배정한 기록표
#즉, 누가 어떤 프로젝트를 맡았는지 (관계), 언제 맡았는지(assigned_at)
# 같은 사람이 같은 프로젝트를 중복으로 배정되는 걸 막을 수도 있음

#배정기록.
CREATE TABLE todo_assignments(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    todo_id BIGINT NOT NULL ,
    user_id BIGINT NOT NULL ,
    assigned_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_todo_user UNIQUE (todo_id, user_id),
    CONSTRAINT fk_assignment_todo FOREIGN KEY (todo_id) REFERENCES todos(id) ON DELETE CASCADE ,
    CONSTRAINT fk_assignment_user Foreign Key (user_id) REFERENCES users(id) ON DELETE CASCADE
)