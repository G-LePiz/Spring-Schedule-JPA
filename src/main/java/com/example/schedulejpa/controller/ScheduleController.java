package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.ScheduleRequestDto;
import com.example.schedulejpa.dto.ScheduleResponseDto;
import com.example.schedulejpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody ScheduleRequestDto requestDto){

        ScheduleResponseDto saveScheduleDto = scheduleService.saveSchedule( // 서비스 단으로 작섣된 스케줄을 저장
                requestDto.getWriteUsername(),
                requestDto.getTodoTitle(),
                requestDto.getTodoContents()
        );

        return new ResponseEntity<>(saveScheduleDto, HttpStatus.CREATED); // 저장된 일정을 출력
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(){
        List<ScheduleResponseDto> allSchedule = scheduleService.findAllSchedule(); // 서비스 단에서 전체 일정을 불러옴

        return new ResponseEntity<>(allSchedule, HttpStatus.OK);
    }
}
