package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.ScheduleRequestDto;
import com.example.schedulejpa.dto.ScheduleResponseDto;
import com.example.schedulejpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody ScheduleRequestDto requestDto){ // 일정 추가

        ScheduleResponseDto saveScheduleDto = scheduleService.saveSchedule( // 서비스 단으로 작섣된 스케줄을 저장
                requestDto.getWriteUsername(),
                requestDto.getTodoTitle(),
                requestDto.getTodoContents()
        );

        return new ResponseEntity<>(saveScheduleDto, HttpStatus.CREATED); // 저장된 일정을 출력
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(){ // 일정 전체 조회
        List<ScheduleResponseDto> allSchedule = scheduleService.findAllSchedule(); // 서비스 단에서 전체 일정을 불러옴

        return new ResponseEntity<>(allSchedule, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id){ // 일정 단건 조회
        ScheduleResponseDto schedulefindById = scheduleService.findScheduleById(id);

        return new ResponseEntity<>(schedulefindById, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id){ // 일정 삭제
        scheduleService.deleteSchedule(id);
    }

}
