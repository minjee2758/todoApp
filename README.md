# 📝 Todo 일정 관리 앱
일정을 생성, 조회, 수정, 삭제할 수 있는 TODO 만들기

## 👀 기능 정리
### 0. ERD
<img width="505" alt="image" src="https://github.com/user-attachments/assets/207edafd-27e3-488f-8d69-1760fdd4690f" />

### 1. 일정 생성 ("/todos")
: 새로운 일정 추가
- 일정 내용(todo), 사용자명(userName), 비밀번호(password), 마감일(doDate), 작성일(createDate), 수정일(updateDate)을 포함함
- 일정마다 고유 ID 자동 생성

### 2. 전체 일정 조회 ("/todos")
: 등록된 전체 일정 목록을 조회

수정일을 기준으로 내림차순 정렬

### 3. 선택 일정 조회 ("/todos/{id}")
: 1건의 일정 조회

고유 ID를 사용하여 조회

### 4. 일정 수정 & 삭제 ("/todos/update/{id}", "/todos/delete/{id}")
: 원하는 id의 일정을 수정 및 삭제

비밀번호를 함께 입력하여 비밀번호가 틀리면 수정(또는 삭제)되지 않음



## 🛠 기술 스택
**Backend** | `Java`, `Spring Boot`, `JDBC`, `MySQL`

**Build Tool** |  `Gradle`

**IDE** | `IntelliJ IDEA`

## 📌 API 명세서
<a href= "https://www.notion.so/1bcc1a66561280ee9a21e02b625e0543?v=1bcc1a6656128031bc2b000cee6fa79b&pvs=4" > 노션에서 보기 </a> 
<img width="800" alt="image" src="https://github.com/user-attachments/assets/af820eda-ff22-45a7-885b-5cfc1a346418" />


