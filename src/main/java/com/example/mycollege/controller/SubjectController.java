package com.example.mycollege.controller;

import com.example.mycollege.service.SubjectService;
import org.springframework.web.bind.annotation.*;
import com.example.mycollege.model.Subject;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) { return subjectService.addSubject(subject); }
}