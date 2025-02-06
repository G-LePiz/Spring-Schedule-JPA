package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String writeUsername; // 작성자명

    private final String todoTitle; // 할일 제목

    private final String todoContents; // 할일 내용

    public ScheduleRequestDto(String writeUsername, String todoTitle, String todoContents) {
        this.writeUsername = writeUsername;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
