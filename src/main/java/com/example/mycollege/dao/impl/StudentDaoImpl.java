package com.example.mycollege.dao.impl;

import com.example.mycollege.repository.StudentRepository;
import com.example.mycollege.model.Student;
import com.example.mycollege.dao.StudentDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final StudentRepository studentRepository;

    public StudentDaoImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setDepartment(studentDetails.getDepartment());
        student.setScore(studentDetails.getScore());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }

    @Override
    public List<Student> getStudentsByDepartment(String dept) {
        return studentRepository.findByDepartment(dept);
    }

    @Override
    public List<Student> getTopStudents() {
        return studentRepository.findTopStudents();
    }

    @Override
    public List<Object[]> getClassRankings() {
        return studentRepository.findClassRankings();
    }
}

