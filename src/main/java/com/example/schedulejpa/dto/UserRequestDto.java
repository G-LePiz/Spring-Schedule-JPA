package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {

    private final String username; // 유저명

    private final String email; // 이메일

    public UserRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
