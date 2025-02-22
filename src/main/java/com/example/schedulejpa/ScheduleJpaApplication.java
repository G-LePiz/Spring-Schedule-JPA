package com.example.schedulejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 기능을 활성화
@SpringBootApplication
public class ScheduleJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleJpaApplication.class, args);
    }

}
