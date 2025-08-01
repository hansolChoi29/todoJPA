# todoJPA project

# API명세서(일정  CRU 기능기준)


스프링부트 + JPA 기반의 일정 관리 백엔드 API입니다.
CRUD 기능을 단계별로 구현하면서 JPA의 연관관계, 지연 로딩(Lazy Loading), DTO 설계 등을 연습합니다.


1.Todo

| Method   | URL           | 요청 Body                                                                                  | 응답 예시                                                                                                                                                                                                    | 설명                 |
| -------- | ------------- | ---------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------ |
| `POST`   | `/todos`      | `json { "ownerId": 1, "title": "JPA 공부", "content": "1단계 끝내기", "assigneeIds": [2, 3] } ` | `json { "id": 1, "title": "JPA 공부", "content": "1단계 끝내기", "ownerName": "한솔", "createdDate": "...", "modifiedAt": "...", "assignees": [ { "id": 2, "userName": "민지", "email": "minji@example.com" } ] } ` | 일정 등록 및 담당자 배정     |
| `GET`    | `/todos/{id}` |                                                                                      | `json { "id": 1, "title": "JPA 공부", "content": "1단계 끝내기", "ownerName": "한솔", "createdDate": "...", "modifiedAt": "...", "assignees": [] } `                                                              | 일정 단건 조회 (담당자 포함)  |
| `GET`    | `/todos`      |                                                                                      | `json [ { "id": 1, "title": "JPA 공부", "content": "...", "ownerName": "한솔", "createdDate": "...", "modifiedAt": "...", "commentCount": 2 } ] `                                                            | 일정 전체 조회 (담당자 제외됨) |
| `PUT`    | `/todos/{id}` | `json { "title": "JPA 정리", "content": "2단계 시작" } `                                       | `json { "id": 1, "title": "JPA 정리", "content": "2단계 시작", "ownerName": "한솔", "createdDate": "...", "modifiedAt": "..." } `                                                                                | 일정 수정              |
| `DELETE` | `/todos/{id}` |                                                                                      | 없음 (204 No Content 또는 메시지 반환 가능)                                                                                                                                                                         | 일정 삭제 (댓글도 함께 삭제됨) |



2. 댓글
 
| Method   | URL              | 요청 Body                                                      | 응답 예시                                                                                                                                                                                                        | 설명       |
| -------- | ---------------- | ------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | -------- |
| `POST`   | `/comments`      | `json { "todoId": 1, "userId": 2, "content": "좋은 일정이네요!" } ` | `json { "id": 1, "todo": { "id": 1, "title": "...", "content": "...", "createdDate": "...", "modifiedAt": "..." }, "authorName": "민지", "content": "좋은 일정이네요!", "createdDate": "...", "modifiedAt": "..." } ` | 댓글 등록    |
| `GET`    | `/comments/{id}` |                                                       | `json { "id": 1, "authorName": "민지", "content": "...", "createdDate": "...", "modifiedAt": "..." } `                                                                                                         | 댓글 단건 조회 |
| `GET`    | `/comments`      |                                                          | `json [ { "id": 1, "authorName": "민지", "content": "좋아요", ... }, { "id": 2, "authorName": "한솔", "content": "감사합니다", ... } ] `                                                                                 | 댓글 전체 조회 |
| `PUT`    | `/comments/{id}` | `json { "content": "수정된 댓글입니다!" } `                          | `json { "id": 1, "authorName": "민지", "content": "수정된 댓글입니다!", "createdDate": "...", "modifiedAt": "..." } `                                                                                                  | 댓글 수정    |
| `DELETE` | `/comments/{id}` |                                                          | `json { "message": "댓글이 성공적으로 삭제되었습니다." } `                                                                                                                                                                  | 댓글 삭제    |

3. 유저

| Method   | URL           | 요청 Body                                                     | 응답 예시                                                                                                           | 설명       |
| -------- | ------------- | ----------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | -------- |
| `POST`   | `/users`      | `json { "userName": "한솔", "email": "hansol@example.com" } ` | `json { "id": 1, "userName": "한솔", "email": "hansol@example.com", "createdDate": "...", "modifiedAt": "..." } ` | 유저 생성    |
| `GET`    | `/users/{id}` |                                                   | 위와 동일                                                                                                           | 유저 단건 조회 |
| `DELETE` | `/users/{id}` |                                                      | 없음 또는 메시지                                                                                                       | 유저 삭제    |



---

# ERD 
<img width="475" height="762" alt="스크린샷(16)" src="https://github.com/user-attachments/assets/9a6b7f74-97a2-4f1a-ba7d-0e8bd090a1bb" />


