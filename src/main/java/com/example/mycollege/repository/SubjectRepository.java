package com.example.mycollege.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mycollege.model.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {}
