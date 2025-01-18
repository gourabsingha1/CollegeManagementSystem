package com.example.mycollege.dao;

import com.example.mycollege.model.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeachers();
    Teacher addTeacher(Teacher teacher);
}
