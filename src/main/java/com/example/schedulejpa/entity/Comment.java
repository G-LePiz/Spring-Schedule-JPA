package com.example.schedulejpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "comment")

public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // 연관관계 설정 // 유저 고유 식별자
    private User user;

    @OneToMany
    @JoinColumn(name = "schedule_id")
    private List<Schedule> schedules = new ArrayList<>(); // 연관관계 설정 // 일정 고유 식별자


}
