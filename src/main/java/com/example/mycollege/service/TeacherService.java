package com.example.mycollege.service;

import com.example.mycollege.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher addTeacher(Teacher teacher);
}
