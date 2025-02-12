package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.ScheduleRequestDto;
import com.example.schedulejpa.dto.ScheduleResponseDto;
import com.example.schedulejpa.entity.BaseEntity;
import com.example.schedulejpa.entity.Schedule;
import com.example.schedulejpa.entity.User;
import com.example.schedulejpa.exceptionhandler.CustomException;
import com.example.schedulejpa.exceptionhandler.ExceptionStatus;
import com.example.schedulejpa.repository.ScheduleRepository;
import com.example.schedulejpa.repository.UserRepository;
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
    private final UserRepository userRepository;

    @Transactional
    public ScheduleResponseDto saveSchedule(String sessionKey, String todoTitle, String todoContents) { // 일정 추가

        User user = userRepository.findByEmail(sessionKey).orElseThrow(
                ()-> new CustomException(ExceptionStatus.EMAIL_DO_NOT_MATCH)
        );

        Schedule schedule = new Schedule(user, todoTitle, todoContents);
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
    public ScheduleResponseDto update(String sessionKey,Long id, ScheduleRequestDto requestDto) { // 일정 수정
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("일정 수정이 불가능")
        );
//        User user = userRepository.findByEmail(sessionKey).orElseThrow(
//                ()-> new CustomException(ExceptionStatus.EMAIL_DO_NOT_MATCH)
//        );

        if (!schedule.getUser().getEmail().equals(sessionKey)){
            throw new CustomException(ExceptionStatus.UPDATE_UNAUTHORIZED);
        }

        schedule.update(requestDto.getTodoTitle(), requestDto.getTodoContents());

        return new ScheduleResponseDto(schedule.getId(), schedule.getUser().getUsername(), schedule.getTodoTitle(), schedule.getTodoContents(), schedule.getCreateDate(), schedule.getUpdateDate());
    }

    @Transactional
    public void deleteSchedule(Long id) {

    }


}
