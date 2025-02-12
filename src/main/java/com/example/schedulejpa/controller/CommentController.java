package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.CommentRequestDto;
import com.example.schedulejpa.dto.CommentResponseDto;
import com.example.schedulejpa.repository.CommentRepository;
import com.example.schedulejpa.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentResponseDto> save(HttpServletRequest request,
                                                   PageRequest pageRequest,
                                                   @PathVariable Long scheduleId,
                                                   @RequestBody CommentRequestDto commentRequestDto){

        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession(true);
        }
        String userEmail = (String) session.getAttribute("sessionKey");

        CommentResponseDto save = commentService.save(commentRequestDto.getComment(), scheduleId/*commentRequestDto.getScheduleId()*/, userEmail);

        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/comments/find/{scheduleId}")
    public ResponseEntity<List<CommentResponseDto>> findAllComment(@PathVariable Long scheduleId){
        List<CommentResponseDto> allComment = commentService.findAllComment(scheduleId);

        return new ResponseEntity<>(allComment, HttpStatus.OK);
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> findCommentById(@PathVariable Long commentId){
        CommentResponseDto comment = commentService.findCommentById(commentId);

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/schedules/{scheduleId}/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(HttpServletRequest request,
                                                            @PathVariable Long scheduleId,
                                                            @PathVariable Long commentId,
                                                            @RequestBody CommentRequestDto commentRequestDto){
        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession(true);
        }
        String userEmail = (String) session.getAttribute("sessionKey");

        CommentResponseDto commentResponseDto = commentService.updateComment(scheduleId, commentId, userEmail, commentRequestDto);

        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("{scheduleId}/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.delete(commentId);


    }
}
