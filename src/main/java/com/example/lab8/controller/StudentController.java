package com.example.lab8.controller;
import com.example.lab8.entity.Student;
import com.example.lab8.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudentsByFaculty(@RequestParam String faculty) {
        return studentRepository.findByFacultyOrderByGpaDesc(faculty);
    }


}

