package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {

    private String username; // 유저명

    private String email; // 이메일

    private String password; // 비밀번호

//    public UserRequestDto(String username, String email, String password) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }
}
