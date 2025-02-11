package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.CommentRequestDto;
import com.example.schedulejpa.dto.CommentResponseDto;
import com.example.schedulejpa.repository.CommentRepository;
import com.example.schedulejpa.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<CommentResponseDto> save(HttpServletRequest request, @RequestBody CommentRequestDto commentRequestDto){

        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession(true);
        }
        String userEmail = (String) session.getAttribute("sessionKey");

        CommentResponseDto save = commentService.save(commentRequestDto.getComment(), commentRequestDto.getScheduleId(), userEmail);

        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentResponseDto>> findAllComment(){
        List<CommentResponseDto> allComment = commentService.findAllComment();

        return new ResponseEntity<>(allComment, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentResponseDto> findCommentById(@PathVariable Long id){
        CommentResponseDto comment = commentService.findCommentById(id);

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/comments/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long id,
                                                            @RequestBody CommentRequestDto commentRequestDto){
        commentService.updateComment(id, commentRequestDto);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.delete(id);
    }
}
