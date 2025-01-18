package com.example.mycollege.dao.impl;

import com.example.mycollege.dao.TeacherDao;
import com.example.mycollege.model.Teacher;
import com.example.mycollege.repository.TeacherRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    private final TeacherRepository teacherRepository;

    public TeacherDaoImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
