package com.example.schedulejpa.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final Long id; // id

    private final String username; // 유저명

    private final String email; // 이메일

    private final LocalDateTime createDate; // 생성일

    private final LocalDateTime updateDate; // 수정일

    public UserResponseDto(Long id, String username, String email, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

}
