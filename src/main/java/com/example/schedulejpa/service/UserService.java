package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.UserRequestDto;
import com.example.schedulejpa.dto.UserResponseDto;
import com.example.schedulejpa.entity.User;
import com.example.schedulejpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public UserResponseDto saveUser(String username, String email, String password) { // 사용자 추가
        User user = new User(username, email, password);
        userRepository.save(user);

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreateDate(), user.getUpdateDate());
    }

    public List<UserResponseDto> findAllUser() { // 사용자 전체 조회
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    public UserResponseDto findUserById(Long id) { // 사용자 단건 조회
        User user = userRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당되는 사용자가 없습니다."));

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreateDate(), user.getUpdateDate());
    }

    public void deleteUser(Long id) { // 사용자 삭제
        userRepository.deleteById(id);
    }
}
