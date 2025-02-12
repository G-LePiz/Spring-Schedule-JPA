package com.example.schedulejpa.repository;

import com.example.schedulejpa.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllBySchedule_Id(Long scheduleId);

    Optional<Comment> findByIdAndSchedule_IdAndUser_Email(Long id, Long scheduleId, String userEmail);

//    @Query("")
//    // cooment, 스케줄 id가 같아야함
//    // comment에 user id
//    // where 절에는 useremail
//    // 이너 조인

}
