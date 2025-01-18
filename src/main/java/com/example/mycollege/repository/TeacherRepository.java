package com.example.mycollege.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mycollege.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {}
