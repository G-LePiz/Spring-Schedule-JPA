package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private String comment;

    private Long ScheduleId;
}
