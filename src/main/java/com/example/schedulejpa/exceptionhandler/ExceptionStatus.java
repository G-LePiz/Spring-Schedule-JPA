package com.example.schedulejpa.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

@Getter
@AllArgsConstructor
public enum ExceptionStatus {

    EMAIL_DO_NOT_MATCH(HttpStatus.BAD_REQUEST, "이메일이 옳바르지않습니다."),
    PASSWORD_DO_NOT_MATCH(HttpStatus.BAD_REQUEST, "비밀번호가 틀렸습니다."),
    CANNOT_UPDATE(HttpStatus.FORBIDDEN, "수정을 할 수 없습니다."),
    CANNOT_FIND_USER(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    EMAIL_IS_EXIST(HttpStatus.CONFLICT, "이미 존재하는 이메일입니다."),
    UPDATE_UNAUTHORIZED(HttpStatus.FORBIDDEN, "수정 권한이 없습니다.");

    private HttpStatus errorCode;
    private String message;
}
