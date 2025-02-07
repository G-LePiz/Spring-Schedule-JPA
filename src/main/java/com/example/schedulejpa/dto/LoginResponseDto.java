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

    public void setSessionid(String sessionid){
        this.sessionid = sessionid;
    }
}
