package com.example.mycollege.service;

import com.example.mycollege.dto.StudentDTO;
import com.example.mycollege.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    Optional<StudentDTO> getStudent(long id);
    Student addStudent(Student student);
    void deleteStudent(long id);
    StudentDTO updateStudent(Long id, StudentDTO studentDetails);
    List<StudentDTO> getStudentsByDepartment(String dept);
    List<StudentDTO> getTopStudents();
    List<Object[]> getClassRankings();
}
