package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private final String email;

    private final String username;

    private String sessionid;

    public LoginResponseDto(String email, String username) {
        this.email = email;
        this.username = username;
    }

//    public void setSessionid(String sessionid){ // 세션 아이디가 제대로 작동하는지 확인
//        this.sessionid = sessionid;
//    }
}
