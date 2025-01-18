package com.example.mycollege.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mycollege.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>  {
    List<Student> findByDepartment(String department);

    @Query("SELECT s FROM Student s ORDER BY s.score DESC")
    List<Student> findTopStudents();

    @Query("SELECT s.department, AVG(s.score) FROM Student s GROUP BY s.department ORDER BY AVG(s.score) DESC")
    List<Object[]> findClassRankings();
}
