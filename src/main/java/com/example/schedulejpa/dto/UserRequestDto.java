package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {

    private final String username; // 유저명

    private final String email; // 이메일

    private final String password; // 비밀번호

    public UserRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
