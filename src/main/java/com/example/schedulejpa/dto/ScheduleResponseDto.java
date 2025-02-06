package com.example.schedulejpa.dto;

import com.example.schedulejpa.entity.BaseEntity;
import com.example.schedulejpa.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id; // id

    private final String writeUsername; // 작성자명

    private final String todoTitle; // 할일 제목

    private final String todoContents; // 할일 내용


    public ScheduleResponseDto(Long id, String writeUsername, String todoTitle, String todoContents) {
        this.id = id;
        this.writeUsername = writeUsername;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule){
        return new ScheduleResponseDto(schedule.getId(),
                schedule.getWriteUsername(), schedule.getTodoTitle(), schedule.getTodoContents());
    }
}
