package com.example.schedulejpa.repository;

import com.example.schedulejpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   default User findUserByEmailAndPassword(String email, String password){
       return findUserByEmailAndPassword(email, password);
   }

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
