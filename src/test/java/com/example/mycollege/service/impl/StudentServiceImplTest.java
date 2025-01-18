package com.example.mycollege.service.impl;

import com.example.mycollege.dao.StudentDao;
import com.example.mycollege.dto.StudentDTO;
import com.example.mycollege.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {

    @Mock
    private StudentDao studentDao;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStudents() {
        // Mock the behavior of DAO
        Student student1 = new Student("Alice", "alice@gmail.com", "CSE", 79L);
        Student student2 = new Student("Bob", "bob@gmail.com", "ECE", 87L);
        when(studentDao.getAllStudents()).thenReturn(Arrays.asList(student1, student2));

        // Call the service method
        var result = studentService.getAllStudents();

        // Validate the result
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Bob", result.get(1).getName());

        // Verify interactions
        verify(studentDao, times(1)).getAllStudents();
    }

    @Test
    void testGetStudent() {
        // Mock the behavior of DAO
        Student student = new Student("Alice", "alice@gmail.com", "CSE", 79L);
        when(studentDao.getStudent(1L)).thenReturn(Optional.of(student));

        // Call the service method
        Optional<StudentDTO> result = studentService.getStudent(1L);

        // Validate the result
        assertTrue(result.isPresent());
        assertEquals("Alice", result.get().getName());

        // Verify interactions
        verify(studentDao, times(1)).getStudent(1L);
    }

    @Test
    void testAddStudent() {
        // Mock the behavior of DAO
        StudentDTO studentDTO = new StudentDTO("Alice", "CSE");
        Student student = new Student("Alice", "alice@gmail.com", "CSE", 79L);

        when(studentDao.addStudent(any(Student.class))).thenReturn(student);

        // Call the service method
        Student result = studentService.addStudent(student);

        // Validate the result
        assertNotNull(result);
        assertEquals("Alice", result.getName());
        assertEquals("CSE", result.getDepartment());

        // Verify interactions
        verify(studentDao, times(1)).addStudent(any(Student.class));
    }

    @Test
    void testUpdateStudent() {
        // Mock DAO behavior
        Student student = new Student("Alice", "alice@gmail.com", "CSE", 79L);
        StudentDTO studentDTO = new StudentDTO("Alice Johnson", "Physics");

        when(studentDao.getStudent(any(Long.class))).thenReturn(Optional.of(student));
        when(studentDao.updateStudent(any(Long.class), any(Student.class)))
                .thenReturn(student);

        // Call the service method
        StudentDTO result = studentService.updateStudent(1L, studentDTO);

        // Validate the result
        assertNotNull(result);
        assertEquals("Alice Johnson", result.getName());
        assertEquals("Physics", result.getDepartment());

        // Verify interactions
        verify(studentDao, times(1)).getStudent(any(Long.class));
        verify(studentDao, times(1)).updateStudent(any(Long.class), any(Student.class));
    }


    @Test
    void testDeleteStudent() {
        // Call the service method
        studentService.deleteStudent(1L);

        // Verify interactions
        verify(studentDao, times(1)).deleteStudent(1L);
    }
}
