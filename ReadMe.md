# 일정 관리 앱 - JPA

## API 목록

## Schedule

| Method | URL             | RequestParam | Response                                                                                                                                                      | Request                                                     | Description | StatusCode | 
|--------|-----------------|--------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------|------------|------------|
| POST   | /schedules      | -            | {<br/>"id":1,<br/>"writeUsername":"test",<br/>"todoTitle":"test,<br/>"todocontents":"test",<br/>"createDate: YYYY-MM-DD,<br/>"updateDate: YYYY-MM-DD"<br/>}   | {<br/>"todotitle":"test"<br/>"todocontents":"test"<br/>}    | 일정 생성      | 일정 등록: 200 | 
| GET    | /schedules      | -            | {<br/>"id":1,<br/>"writeUsername":"test",<br/>"todoTitle":"test,<br/>"todocontents":"test",<br/>"createDate: YYYY-MM-DD,<br/>"updateDate: YYYY-MM-DD"<br/>}   |                                                             |    일정 조회     | 일정 조회: 200 |  |
| GET    | /schedules/{id} | shceduleId   | {<br/>"id":1,<br/>"writeUsername":"test",<br/>"todoTitle":"test,<br/>"todocontents":"test",<br/>"createDate: YYYY-MM-DD,<br/>"updateDate: YYYY-MM-DD"<br/>}   |                                                             |                                         단건 일정 조회                       | 일정 조회: 200 ||
| PUT    | /schedules/{id} | shceduleId   | {<br/>"id":1,<br/>"writeUsername":"test",<br/>"todoTitle":"test3,<br/>"todocontents":"test3",<br/>"createDate: YYYY-MM-DD,<br/>"updateDate: YYYY-MM-DD"<br/>} | {<br/>"todoTitle":"test3",<br/>"todocontents":"test3"<br/>} | 일정 수정      | 일정 수정: 200 |
| DELETE | /schedules/{id} | scheduleId   |                                                                                                                                                               |                                                             | 일정 삭제      | 일정 삭제: 200 |

## User

| Method | URL           | RequestParam | Response                                                                                                                                                     | Request                                                                                   | Description | StatusCode | 
|-------|---------------|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|------------|------------|
| POST  | /users/signin | -            | {<br/>"id":1,<br/>"username":"test",<br/>"email":"test@gmail.com",<br/>"createDate: YYYY-MM-DD,<br/>"updateDate: YYYY-MM-DD"<br/>}                           | {<br/>"username":"test"<br/>"email":"test@gmail.com",<br/>"password":"test12345678"<br/>} | 회원가입       | 회원 등록: 200 | 
| POST  | /users/login  | -            | {<br/>"email":"test@gmail.com",<br/>"username":"test"<br/>}<br/>                                                                                                  | {<br/>"email":"test@gmail.com",<br/>"password":"test"<br/>}                               | 로그인        | 로그인 성공: 200 |
| GET   | /users        | -            | {<br/>"id":1,<br/>"username":"test",<br/>"email":"test@gmail.com",<br/>"createDate: YYYY-MM-DD,<br/>"updateDate: YYYY-MM-DD"<br/>}   |                                                                                           | 회원 조회      | 회원 조회: 200 |  |
| GET   | /users/{id}   | shceduleId   | {<br/>"id":1,<br/>"username":"test",<br/>"email":"test@gmail.com",<br/>"createDate: YYYY-MM-DD,<br/>"updateDate: YYYY-MM-DD"<br/>}   |                                                                                           | 단건 회원 조회   | 회원 조회: 200 ||
| PUT   | /users/{id}   | shceduleId   | {<br/>"id":1,<br/>"username":"test",<br/>"email":"test@gmail.com",<br/>"createDate: YYYY-MM-DD,<br/>"updateDate: YYYY-MM-DD"<br/>} | {<br/>"username":"test"<br/>"password":"test12345678"<br/>"email":"test@gmail.com",<br/>}                               | 회원 수정      | 회원 수정: 200 |
| DELETE | /users/{id}   | scheduleId   |                                                                                                                                                              |                                                                                           | 일정 삭제      | 회원 삭제: 200 |

## Comment
| Method | URL                                            | RequestParam         | Response                                                      | Request                       | Description | StatusCode | 
|--------|------------------------------------------------|----------------------|---------------------------------------------------------------|-------------------------------|------------|------------|
| POST   | /schedules/{scheduleId}/comments               | scheduleId                     | {<br/>"id":1,<br/>"comment":"test",<br/>"scheduleId":1,<br/>       | {<br/>"comments":"test"<br/>} | 댓글 생성      | 댓글 등록: 200 | 
| GET    | /schedules/find/{scheduleId}                   | scheduleId           | {<br/>"id":1,<br/>"comment":"test",<br/>"scheduleId":1<br/>}  |                               | 댓글 조회      | 댓글 조회: 200 |  |
| GET    | /schedules/{commentsId}                        | commentsId           | {<br/>"id":1,<br/>"comment":"test",<br/>"scheduleId":1<br/>}  |                               | 단건 댓글 조회   | 댓글 조회: 200 ||
| PUT    | /schedules/{commentsId}                        | commentsId           | {<br/>"id":1,<br/>"comment":"test2",<br/>"scheduleId":1<br/>} | {<br/>"comments":"test2<br/>} | 댓글 수정      | 댓글 수정: 200 |
| DELETE | /schedules/{schedulesId}/comments/{commentsId} | scheduleId,commentsId |                                                               |                               | 댓글 삭제      | 댓글 삭제: 200 |

## ERD
![1](/images/1.png)

## SQL

## 1. Schedule
```
alter table schedule
add create_date datetime(6) null;

alter table schedule
add id bigint auto_increment
primary key;

alter table schedule
add update_date datetime(6) null;

alter table schedule
add user_id bigint null;

alter table schedule
add todo_contents longtext null;

alter table schedule
add todo_title varchar(255) not null;
```
### 2. User
```
create table user
(
    create_date datetime(6)  null,
    id          bigint auto_increment
        primary key,
    update_date datetime(6)  null,
    email       varchar(255) not null,
    password    varchar(255) not null,
    username    varchar(255) not null
);
```

### 3. Comment
```
create table user
(
create_date datetime(6)  null,
id          bigint auto_increment
primary key,
update_date datetime(6)  null,
email       varchar(255) not null,
password    varchar(255) not null,
username    varchar(255) not null
);
```

# 📱 JPA를 활용하여 일정관리 앱을 만들어보자!
Spring을 처음 배우고 낮설어하는 개발자를 위해, 직접 개발하면서 Spring에 한 발자국을 다가갈 수 있는 과제입니다. 이 과제를 통해서 3-Layer Architecture에 대해서 익숙해질 수 있고 무엇보다 가장 중요한 CURD에 대해서 쉽게 이해할 수 있습니다!

# ⚠️ 클래스 설명
1. Controller
- 클라이언트에게 요청을 받고 응답하는 역할을 함
2. Service
- 비즈니스 로직을 수행함
- 요청을 해석해서 레포지토리 계층에게 전달함
3. Repository
- 데이터베이스와 연동하여 실제 데이터를 관리함
- CRUD를 수행
4. Entity
- 테이블과 매핑이 되는 클래스
5. RequestDto
- 클라이언트가 서버에게 요청하는 것
6. ResponseDto
- 서버가 클라이언트에게 응답하는 것
7. Filter
- 로그인을 할때 로그인을 했는지 안했는지 먼저 체크
8. Exceptionhandler
- 다양한 예외처리
9. Config
- 필터의 조건을 정함

# 🖥️ 개발환경
- JAVA 8
- JDK 21.0.5
- Spring Boot
- InteliJ IDEA
- JPA
- My SQL

# 🕰️ 개발기간
2025-02-06 ~ 2025-02-13

# 📌 필수기능

## Lv 1. 일정  CURD
1. ### 일정을 생성, 조회, 수정, 삭제할 수 있습니다.
2. ### 일정은 아래와 같은 필드를 가집니다.
- 작성 유저명, 할일 제목, 할일 내용, 작성일, 수정일 필드
- 작성일, 수정일 필드는 JPA Auditing을 활용

## Lv 2. 유저 CURD
1. ### 유저를 생성, 조회, 수정, 삭제할 수 있습니다.
2. ### 일정은 다음과 같은 필드를 가집니다.
- 유저명, 이메일, 작성일, 수정일 필드
- 작성일, 수정일 필드는 JPA Auditing을 활용

2. ### 연관관계 구현
- 일정은 이제 작성 유저명 필드 대신 유저 고유 식별자 필드를 가집니다. (@OneToMany)

## Lv 3. 회원가입
1. ### 유저에 **비밀번호** 필드를 추가합니다.

## LV 4. 로그인(인증)
1. **Cookie/Session**을 활용해 로그인 기능을 구현합니다.
 필터를 활용해 인증 처리를 할 수 있습니다.
`@Configuration` 을 활용해 필터를 등록할 수 있습니다.

2. **조건**
- `이메일`과 `비밀번호`를 활용해 로그인 기능을 구현합니다.
- 회원가입, 로그인 요청은 인증 처리에서 제외합니다.
3. **예외처리**
- 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 HTTP Status code 401을 반환합니다.

# ⭐ 도전기능

## LV 5. 다양한 예외처리 적용하기
1. Validation을 활용해 다양한 예외처리를 적용합니다.
2. 정해진 예외처리 항목이 있는 것이 아닌 프로젝트를 분석하고 예외사항을 지정해봅니다.

## LV 6. 비밀번호 암호화
1. LV3에서 추가한 비밀번호 필드에 들어가는 비밀번호를 암호화합니다.

## LV 7. 댓글 CRUD
1. 생성한 일정에 댓글을 남길 수 있습니다.
2. 댓글을 저장, 수정, 조회, 삭제할 수 있습니다.