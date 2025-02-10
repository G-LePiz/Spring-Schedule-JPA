package com.example.schedulejpa.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Parent;
import org.hibernate.validator.constraints.Range;

@Getter
public class UserRequestDto {

    @NotBlank(message = "사용하실 유저명을 입력하세요.")
    @Size(min = 1, max = 4)
    private String username; // 유저명

    @NotBlank(message = "이메일을 입력하세요.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.") // 패턴 정규식을 통한 검증
    private String email; // 이메일

    @NotBlank(message = "비밀번호를 입력하세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*\\W)[^\\s]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password; // 비밀번호

//    public UserRequestDto(String username, String email, String password) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }
}
