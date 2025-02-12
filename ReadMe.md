# 일정 관리 앱 - JPA

## API 목록

| Method | URL             | RequestParam         | Response                                                                                            | Request                                                                                                          | Description | StatusCode  | 
|--------|-----------------|----------------------|-----------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|------------|-------------|
| POST   | /schedules      | -                    | {<br/>"todo":"놀기"<br/>"user":"최다원"<br/>"createDate: YYYY-MM-DD<br/>"updateDate: YYYY-MM-DD<br/>}    | {<br/>"todo":"놀기"<br/>"user":"최다원"<br/>"password":"1234"<br/>}                                                   | 일정 생성      | 일정 등록: 200  | 
| GET    | /schedules      | -                    | {<br/>"todo":"놀기"<br/>"user":"최다원"<br/>"createDate: YYYY-MM-DD<br/>"updateDate: YYYY-MM-DD<br/>}    | http://localhost:8080/api/schedules                                                                              |    일정 조회     | 일정 조회: 200ㅂ |  |
| GET    | /schedules/{id} | updateDate, username | {<br/>"todo":"놀기"<br/>"user":"최다원"<br/>"createDate: YYYY-MM-DD<br/>"updateDate: YYYY-MM-DD<br/>}... | http://localhost:8080/api/schedules/2                                                                            |                                         단건 일정 조회                       | 일정 조회: 200  ||
| PUT    | /schedules/{id} | -                    |     {<br/>"todo":"놀기2"<br/>"user":"최다원2"<br/>"createDate: YYYY-MM-DD<br/>"updateDate: YYYY-MM-DD<br/>}                                                                                                | http://localhost:8080/api/schedules/2      <br/>{<br/>"todo":"놀기2"<br/>"user":"최다원2"<br/>"password":"1234"<br/>} | 일정 수정      | 일정 수정: 200  |
| DELETE | /schedules/{id} | -                    |                                                                                                     | http://localhost:8080/api/schedules/2<br/>{<br/>"password":"1234"<br/>}                                          | 일정 삭제      | 일정 삭제: 200  |

## ERD
![1](/images/1.png)
# 📱 일정관리 앱을 만들어보자!
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
1. **Cookie/Session**을 활용해 로그인 기능을 구현합니다. → `2주차 Servlet Filter 실습 참고!`
 필터를 활용해 인증 처리를 할 수 있습니다.
`@Configuration` 을 활용해 필터를 등록할 수 있습니다.


2. **조건**
- `이메일`과 `비밀번호`를 활용해 로그인 기능을 구현합니다.
- 회원가입, 로그인 요청은 인증 처리에서 제외합니다.
3. **예외처리**
- 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 HTTP Status code 401을 반환합니다.

# ⭐ 도전기능

## LV 5. 다양한 예외처리 적용하기