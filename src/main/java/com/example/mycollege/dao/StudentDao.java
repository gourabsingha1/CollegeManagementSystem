package com.example.mycollege.dao;

import com.example.mycollege.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> getAllStudents();
    Optional<Student> getStudent(long id);
    Student addStudent(Student student);
    void deleteStudent(long id);
    Student updateStudent(Long id, Student studentDetails);
    List<Student> getStudentsByDepartment(String dept);
    List<Student> getTopStudents();
    List<Object[]> getClassRankings();
}
