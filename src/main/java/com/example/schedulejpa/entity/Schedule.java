package com.example.schedulejpa.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{ // BaseEnity에게 상속을 받아야 작성일, 수정일 사용가능

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id

    @Column(nullable = false) // 작성 유저명은 필수여야함
    private String writeUsername; // 작성 유저명

    @Column(nullable = false) // 제목은 필수여야함
    private String todoTitle; // 할일 제목

    @Column(columnDefinition = "longtext")
    private String todoContents; // 할일 내용

    @ManyToOne
    @JoinColumn(name = "user_id") // 연관관계 설정 // 유저 고유 식별자
    private User user;

    @OneToMany
    @JoinColumn(name = "schedule_id")
    private List<Schedule> schedules = new ArrayList<>();

    public Schedule(String writeUsername, String todoTitle, String todoContents) {
        this.writeUsername = writeUsername;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }

    public Schedule() {

    }

    public void update(String todoTitle, String todoContents, String writeUsername) {
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
        this.writeUsername = writeUsername;
    }
}
