package com.example.schedulejpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 해당 어노테이션이 선언된 클래스를 상속받는 엔티티에 공통 매핑 정보를 제공
@EntityListeners(AuditingEntityListener.class) // 엔티티를 DB에 적용하기 전, 커스텀 콜백을 요청할 수 있는 어노테이션
public class BaseEntity {

    @CreatedDate // 생성 시점의 날짜를 자동으로 기록
    @Column(updatable = false) // 작성일은 수정 불가능
    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입을 세부적으로 지정
    private LocalDateTime createDate; // 작성일

    @LastModifiedDate // 수정 시점의 날짜를 자동으로 기록
    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입을 세부적으로 지정
    private LocalDateTime updateDate; // 수정일
}
