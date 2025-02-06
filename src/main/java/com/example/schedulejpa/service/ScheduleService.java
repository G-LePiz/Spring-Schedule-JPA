package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.ScheduleResponseDto;
import com.example.schedulejpa.entity.BaseEntity;
import com.example.schedulejpa.entity.Schedule;
import com.example.schedulejpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto saveSchedule(String writeUsername, String todoTitle, String todoContents) {
        Schedule schedule = new Schedule(writeUsername, todoTitle, todoContents);
        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),schedule.getWriteUsername(),schedule.getTodoTitle(), schedule.getTodoContents());
    }

    public List<ScheduleResponseDto> findAllSchedule() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }
}
