package com.example.lab8.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="gpa", nullable = false)
    private double gpa;

    @Column(name="faculty", nullable = false)
    private String faculty;

    @Column(name="completed_credits", nullable = false)
    private int completedCredits;

    @Column(name="rankin", nullable = false)
    private int rankin;
}

