package com.example.mycollege.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "students")
@Builder(toBuilder = true)
@AllArgsConstructor
public class Student {
    public static final Logger logger = LoggerFactory.getLogger(Student.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String department;
    private Long score;

    public Student() {
        logger.info("**** Student entity created! ****");
    }

    public Student(String name, String email, String department, Long score) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}

