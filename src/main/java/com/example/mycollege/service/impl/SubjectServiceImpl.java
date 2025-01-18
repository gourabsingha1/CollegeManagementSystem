package com.example.mycollege.service.impl;

import com.example.mycollege.dao.SubjectDao;
import com.example.mycollege.model.Subject;
import com.example.mycollege.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDao subjectDao;

    public SubjectServiceImpl(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }

    @Override
    public Subject addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }
}
