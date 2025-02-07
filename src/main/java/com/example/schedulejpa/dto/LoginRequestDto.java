package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class LoginRequestDto {

    private String email; // 이메일

    private String password; // 비밀번호

//    public LoginRequestDto(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
}
