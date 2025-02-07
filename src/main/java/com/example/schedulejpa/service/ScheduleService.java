package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.ScheduleRequestDto;
import com.example.schedulejpa.dto.ScheduleResponseDto;
import com.example.schedulejpa.entity.BaseEntity;
import com.example.schedulejpa.entity.Schedule;
import com.example.schedulejpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto saveSchedule(String writeUsername, String todoTitle, String todoContents) { // 일정 추가
        Schedule schedule = new Schedule(writeUsername, todoTitle, todoContents);
        scheduleRepository.save(schedule);

        return ScheduleResponseDto.toDto(schedule);
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAllSchedule() { // 일정 전체 조회
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findScheduleById(Long id) { // 일정 단건 조회

        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 일정이 없습니다."));

        return ScheduleResponseDto.toDto(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id) { // 일정 삭제
        scheduleRepository.deleteById(id);
    }
}
