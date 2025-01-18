package com.example.mycollege.dao.impl;

import com.example.mycollege.dao.SubjectDao;
import com.example.mycollege.model.Subject;
import com.example.mycollege.repository.SubjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDaoImpl implements SubjectDao {

    private final SubjectRepository subjectRepository;

    public SubjectDaoImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
