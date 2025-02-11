package com.example.schedulejpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "comment")
@NoArgsConstructor

public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id") // 연관관계 설정 // 유저 고유 식별자
    private User user;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule; // 연관관계 설정 // 일정 고유 식별자

    public Comment(String comment, User user, Schedule schedule) {
        this.comment = comment;
        this.user = user;
        this.schedule = schedule;
    }

    public void update(String comment) {
        this.comment = comment;
    }
}
