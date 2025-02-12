package com.example.schedulejpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends BaseEntity{ // BaseEnity에게 상속을 받아야 작성일, 수정일 사용가능

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id

    @Column(nullable = false) // 제목은 필수여야함
    private String todoTitle; // 할일 제목

    @Column(columnDefinition = "longtext")
    private String todoContents; // 할일 내용

    @ManyToOne // 1:N 관계에서는 N인 엔티티의 필드에 작성, 1은 유저이고, N은 일정들
    @JoinColumn(name = "user_id") // 연관관계 설정 // 유저 고유 식별자
    private User user;

    @OneToMany(mappedBy = "schedule") // 1:N 관계에서 1인 엔티티의 필드에 작성, 1은 일정이고, N은 댓글들
    private List<Comment> comments = new ArrayList<>();

    public Schedule(User user, String todoTitle, String todoContents) {
        this.user = user;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }

    public void update(String todoTitle, String todoContents) {
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
