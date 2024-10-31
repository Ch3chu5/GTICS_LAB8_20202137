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

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        student.setRankin(1);
        Student savedStudent = studentRepository.save(student);
        updateRanks(student.getFaculty());
        return savedStudent;
    }

    @PutMapping("/{id}")
    public Student updateGpa(@PathVariable Integer id, @RequestParam double gpa) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setGpa(gpa);
        studentRepository.save(student);
        updateRanks(student.getFaculty());
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
        updateRanks(student.getFaculty());
    }

    private void updateRanks(String faculty) {
        List<Student> students = studentRepository.findByFacultyOrderByGpaDesc(faculty);
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setRankin(i + 1);
            studentRepository.save(students.get(i));
        }
    }
}

