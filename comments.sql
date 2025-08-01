USE todo;
CREATE TABLE comments
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    todo_id     BIGINT      NOT NULL,
    user_id BIGINT NOT NULL ,
    content     TEXT        NOT NULL,
    create_at   DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_comment_todo FOREIGN KEY (todo_id)
        REFERENCES todos(id)
        ON DELETE CASCADE
)
