package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.LoginRequestDto;
import com.example.schedulejpa.dto.LoginResponseDto;
import com.example.schedulejpa.dto.UserRequestDto;
import com.example.schedulejpa.dto.UserResponseDto;
import com.example.schedulejpa.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/signin")
    public ResponseEntity<UserResponseDto> saveUser(@Valid @RequestBody UserRequestDto requestDto){ // 유저 생성
        UserResponseDto userResponseDto = userService.saveUser(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/users/login")
    public ResponseEntity<LoginResponseDto> loginUser(HttpServletRequest request, @RequestBody LoginRequestDto loginDto){ // 유저 로그인

        LoginResponseDto loginUser = userService.loginUser(loginDto.getEmail(), loginDto.getPassword());

        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession(true);
        }
        session.setAttribute("sessionKey", loginUser.getEmail());
        //loginUser.setSessionid(session.getId());

        return new ResponseEntity<>(loginUser, HttpStatus.OK);

    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findAllUser(){ // 유저 전체 조회
        List<UserResponseDto> findAllUser = userService.findAllUser();
        return new ResponseEntity<>(findAllUser, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id){ // 유저 단건 조회
        UserResponseDto findUserById = userService.findUserById(id);
        return new ResponseEntity<>(findUserById, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id,
                                                      @RequestBody UserRequestDto requestDto){ // 유저 수정
        UserResponseDto update = userService.update(id, requestDto);

        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){ // 유저 삭제
        userService.deleteUser(id);
    }
}
