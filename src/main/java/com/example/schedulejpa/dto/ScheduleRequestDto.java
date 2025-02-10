package com.example.schedulejpa.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
public class ScheduleRequestDto {

    private String writeUsername; // 작성자명

    @Range(min = 1, max = 10)
    private String todoTitle; // 할일 제목

    @Range(min = 1, max = 100)
    private String todoContents; // 할일 내용

}
