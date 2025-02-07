package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String writeUsername; // 작성자명

    private String todoTitle; // 할일 제목

    private String todoContents; // 할일 내용

}
