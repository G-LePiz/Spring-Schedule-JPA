package com.example.schedulejpa.exception;

import org.springframework.http.HttpStatus;

public class DuplicationError extends ApplicationException {
    public DuplicationError() {
        super("이미 가입된 이메일이 있습니다. 회원가입이 불가합니다.", HttpStatus.UNAUTHORIZED);
    }
}
