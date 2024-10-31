package com.example.lab8.repository;
import com.example.lab8.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFacultyOrderByGpaDesc(String faculty);
}
