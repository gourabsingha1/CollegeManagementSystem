package com.example.mycollege.service.impl;

import com.example.mycollege.dao.TeacherDao;
import com.example.mycollege.model.Teacher;
import com.example.mycollege.service.TeacherService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }
}

