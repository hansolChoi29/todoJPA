# todoJPA project

# API명세서(일정  CRU 기능기준)

1.  일정 등록 (Create)
    - URL: POST/todos
```json
{
  "userName": "한솔",
  "title": "JPA 공부하기",
  "content": "1단계 과제 끝내기"
}

```
응답 예시
```json
{
  "id": 1,
  "userName": "한솔",
  "title": "JPA 공부하기",
  "content": "1단계 과제 끝내기",
  "createdAt": "2025-07-31T13:00:00",
  "modifiedAt": "2025-07-31T13:00:00"
}
```


2. 일정 단건 조회(Read)
  -  URL: GET/todos/{id}

```json
{
  "id": 1,
  "userName": "한솔",
  "title": "JPA 공부하기",
  "content": "1단계 과제 끝내기",
  "createdAt": "2025-07-31T13:00:00",
  "modifiedAt": "2025-07-31T13:00:00"
}
```


3. 일정 수정(Update)
  - URL: PUT/todos/{id}

```json
{
  "title": "JPA 마무리",
  "content": "1단계 완료하고 2단계 준비하기"
}

```

응답 예시
```
{
  "id": 1,
  "userName": "한솔",
  "title": "JPA 마무리",
  "content": "1단계 완료하고 2단계 준비하기",
  "createdAt": "2025-07-31T13:00:00",
  "modifiedAt": "2025-07-31T14:00:00"
}
```

# API명세서(댓글  CRUD 기능기준)


1. 댓글 등록(Create)
  - URL: POST /comments
```json
{
  "todoId": 1,
  "userName": "한솔",
  "content": "좋은 일정이네요!"
}

```
응답예시
```json
{
  "id": 1,
  "todoId": 1,
  "userName": "민지",
  "content": "좋은 일정이네요!",
  "createdAt": "2025-08-01T10:00:00",
  "modifiedAt": "2025-08-01T10:00:00"
}
```


2. 댓글 단건 조회(Read)
URL: GET/comments/{id}
응답 예시
```json
{
  "id": 1,
  "todoId": 1,
  "userName": "한솔",
  "content": "좋은 일정이네요!",
  "createdAt": "2025-08-01T10:00:00",
  "modifiedAt": "2025-08-01T10:00:00"
}
```


3. 댓글 전체 조회(Read All)
URL: GET /comments
응답 예시
```json
[
  {
    "id": 1,
    "todoId": 1,
    "userName": "민지",
    "content": "좋은 일정이네요!",
    "createdAt": "2025-08-01T10:00:00",
    "modifiedAt": "2025-08-01T10:00:00"
  },
  {
    "id": 2,
    "todoId": 1,
    "userName": "한솔",
    "content": "감사합니다!",
    "createdAt": "2025-08-01T11:00:00",
    "modifiedAt": "2025-08-01T11:00:00"
  }
]
```


4. 댓글 수정 (Update)

- URL : PUT /comments/{id}
```json
{
  "content": "수정된 댓글입니다!"
}
```

- 응답예시
```json
{
  "id": 1,
  "todoId": 1,
  "userName": "민지",
  "content": "수정된 댓글입니다!",
  "createdAt": "2025-08-01T10:00:00",
  "modifiedAt": "2025-08-01T12:00:00"
}
```


5. 댓글 삭제(Delete)
URL : DELETE/comments/{id}

응답예시
```json
{
  "message": "댓글이 성공적으로 삭제되었습니다."
}
```


---

# ERD 
<img width="475" height="762" alt="스크린샷(16)" src="https://github.com/user-attachments/assets/9a6b7f74-97a2-4f1a-ba7d-0e8bd090a1bb" />


