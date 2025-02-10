package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.LoginResponseDto;
import com.example.schedulejpa.dto.UserRequestDto;
import com.example.schedulejpa.dto.UserResponseDto;
import com.example.schedulejpa.entity.User;
import com.example.schedulejpa.exception.PasswordAndEmailException;
import com.example.schedulejpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto saveUser(String username, String email, String password) { // 사용자 추가, 회원가입
        User user = new User(username, email, password);
        userRepository.save(user);

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreateDate(), user.getUpdateDate());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser() { // 사용자 전체 조회
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserById(Long id) { // 사용자 단건 조회
        User user = userRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당되는 사용자가 없습니다."));

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreateDate(), user.getUpdateDate());
    }

    @Transactional
    public void deleteUser(Long id) { // 사용자 삭제
        userRepository.deleteById(id);
    }

    @Transactional
    public LoginResponseDto loginUser(String email, String password){ // 로그인 기능
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("사용자가 없습니다."));

        if (!user.matchPassword(password)){ // 이메일과 비밀번호가 맞지않는 경우에는 401 에러처리
            throw new PasswordAndEmailException();
        }

        return new LoginResponseDto(user.getEmail(), user.getUsername());
    }

    @Transactional
    public UserResponseDto update(Long id, UserRequestDto requestDto) { // 유저 수정

        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("수정할 수 없습니다."));

        user.update(requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail());

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreateDate(), user.getUpdateDate());
    }
}
