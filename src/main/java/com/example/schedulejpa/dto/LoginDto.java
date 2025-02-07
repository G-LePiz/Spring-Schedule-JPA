package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class LoginDto {

    private final String email; // 이메일

    private final String password; // 비밀번호

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
