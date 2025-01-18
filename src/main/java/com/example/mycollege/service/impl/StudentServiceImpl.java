package com.example.mycollege.service.impl;

import com.example.mycollege.dao.StudentDao;
import com.example.mycollege.dto.StudentDTO;
import com.example.mycollege.model.Student;
import com.example.mycollege.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentDao.getAllStudents()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> getStudent(long id) {
        return studentDao.getStudent(id).map(this::convertToDTO);
    }

    @Override
    public Student addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDetails) {
        Optional<Student> studentOptional = studentDao.getStudent(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(studentDetails.getName());
            student.setDepartment(studentDetails.getDepartment());
            Student updatedStudent = studentDao.updateStudent(id, student);
            return convertToDTO(updatedStudent);
        } else {
            return null;
        }
    }

    @Override
    public List<StudentDTO> getStudentsByDepartment(String dept) {
        return studentDao.getStudentsByDepartment(dept)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getTopStudents() {
        return studentDao.getTopStudents()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object[]> getClassRankings() {
        return studentDao.getClassRankings();
    }

    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(student.getName(), student.getDepartment());
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        return new Student(studentDTO.getName(), "", studentDTO.getDepartment(), 0L);  // Assume default values for missing fields
    }
}
