package com.example.schedulejpa.exception;

import org.springframework.http.HttpStatus;

public class PasswordAndEmailException extends ApplicationException {
    public PasswordAndEmailException() {
        super("비밀번호와 이메일이 옳바르지 않습니다.", HttpStatus.UNAUTHORIZED);
    }
}
