package com.example.mycollege.controller;

import com.example.mycollege.dto.StudentDTO;
import com.example.mycollege.model.Student;
import com.example.mycollege.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable long id) {
        return studentService.getStudent(id).orElse(null);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/department/{dept}")
    public List<StudentDTO> getStudentsByDepartment(@PathVariable String dept) {
        return studentService.getStudentsByDepartment(dept);
    }

    @GetMapping("/top")
    public List<StudentDTO> getTopStudents() {
        return studentService.getTopStudents();
    }

    @GetMapping("/ranking")
    public List<Object[]> getClassRankings() {
        return studentService.getClassRankings();
    }

}

