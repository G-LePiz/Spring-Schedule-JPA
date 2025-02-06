package com.example.schedulejpa.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{

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
    @JoinColumn(name = "writeUser_id")
    private User user;

    public Schedule(String writeUsername, String todoTitle, String todoContents) {
        this.writeUsername = writeUsername;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }

    public Schedule() {

    }
}
