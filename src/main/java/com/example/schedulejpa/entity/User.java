package com.example.schedulejpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
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
        this.password = password;
    }

    public User() {

    }

    public void update(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
