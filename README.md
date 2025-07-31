# todoJPA project

# API명세서(일정  CRU 기능기준)

1.  일정 등록 (Create)
    - URL: POST/todos
```json
{
  "writer": "한솔",
  "title": "JPA 공부하기",
  "content": "1단계 과제 끝내기"
}
```
응답 예시
```json
{
  "id": 1,
  "writer": "한솔",
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
  "writer": "한솔",
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
  "writer": "한솔",
  "title": "JPA 마무리",
  "content": "1단계 완료하고 2단계 준비하기",
  "createdAt": "2025-07-31T13:00:00",
  "modifiedAt": "2025-07-31T14:00:00"
}
```

---

# ERD 

```
┌────────────────────────┐
│      todos             │
├────────────────────────┤
│ id (PK)                │← 일정 ID (기본키)
│ writer                 │← 작성자 이름
│ title                  │← 할 일 제목
│ content                │← 내용
│ created_at             │← 생성일
│ modified_at            │← 수정일
└────────────────────────┘

```

