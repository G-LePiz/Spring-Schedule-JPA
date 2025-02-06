package com.example.schedulejpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id

    @Column(nullable = false) // 유저명은 필수여야함
    private String username; // 유저명

    @Column(nullable = false) // 이메일은 필수여야함
    private String email; // 이메일



}
