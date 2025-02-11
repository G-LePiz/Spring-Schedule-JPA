package com.example.schedulejpa.entity;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User extends BaseEntity{ // BaseEnity에게 상속을 받아야 작성일, 수정일 사용가능

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id

    @Column(nullable = false) // 유저명은 필수여야함
    private String username; // 유저명

    @Column(nullable = false) // 이메일은 필수여야함
    private String email; // 이메일

    @Column(nullable = false) // 비밀번호는 필수여야함
    private String password; // 비밀번호



    public User(String username, String email,String password) {
        this.username = username;
        this.email = email;
        this.password = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, password.toCharArray()); // 인코딩 암호화를 해버림
    }


    public void update(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public boolean matchPassword(String password) { // 입력한 비밀번호가 암호화된 비밀번호와 같은지 확인
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), this.password);
        return result.verified;
    }
}
