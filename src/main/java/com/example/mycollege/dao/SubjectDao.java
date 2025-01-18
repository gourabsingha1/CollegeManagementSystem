package com.example.mycollege.dao;

import com.example.mycollege.model.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> getAllSubjects();
    Subject addSubject(Subject subject);
}
