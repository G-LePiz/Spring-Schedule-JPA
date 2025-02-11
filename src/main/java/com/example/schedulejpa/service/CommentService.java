package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.CommentRequestDto;
import com.example.schedulejpa.dto.CommentResponseDto;
import com.example.schedulejpa.entity.Comment;
import com.example.schedulejpa.entity.Schedule;
import com.example.schedulejpa.entity.User;
import com.example.schedulejpa.repository.CommentRepository;
import com.example.schedulejpa.repository.ScheduleRepository;
import com.example.schedulejpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CommentResponseDto save(String comment, Long ScheduleId, String userEmail) {

        User user = userRepository.findByEmail(userEmail).orElseThrow(
                () -> new IllegalArgumentException("회원이 없습니다.")
        );

        Schedule schedule = scheduleRepository.findById(ScheduleId).orElseThrow(
                () -> new IllegalArgumentException("일정이 없습니다.")
        );

        Comment comments = new Comment(comment, user, schedule);

        commentRepository.save(comments);

        return new CommentResponseDto(comments.getId(), comments.getComment(), comments.getSchedule().getId());
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> findAllComment() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentResponseDto> dtos = new ArrayList<>();

        for (Comment comment : comments) {
            dtos.add(new CommentResponseDto(comment.getId(), comment.getComment(), comment.getSchedule().getId()));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public CommentResponseDto findCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 없습니다.")
        );

        return new CommentResponseDto(comment.getId(), comment.getComment(), comment.getSchedule().getId());
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("수정할 수 없습니다.")
        );

        comment.update(commentRequestDto.getComment());

        return new CommentResponseDto(comment.getId(), comment.getComment(), comment.getSchedule().getId());
    }

    @Transactional
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
