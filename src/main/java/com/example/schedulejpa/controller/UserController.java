package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.UserRequestDto;
import com.example.schedulejpa.dto.UserResponseDto;
import com.example.schedulejpa.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto requestDto){ // 유저 생성
        UserResponseDto userResponseDto = userService.saveUser(requestDto.getUsername(), requestDto.getEmail());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUser(){ // 유저 전체 조회
        List<UserResponseDto> findAllUser = userService.findAllUser();
        return new ResponseEntity<>(findAllUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id){ // 유저 단건 조회
        UserResponseDto findUserById = userService.findUserById(id);
        return new ResponseEntity<>(findUserById, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
