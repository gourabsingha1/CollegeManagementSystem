package com.example.mycollege.service;

import com.example.mycollege.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject addSubject(Subject subject);
}
