package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class CommentResponseDto {

    private final Long id;

    private final String comment;

    private final Long ScheduleId;

    public CommentResponseDto(Long id, String comment, Long scheduleId) {
        this.id = id;
        this.comment = comment;
        this.ScheduleId = scheduleId;
    }
}
