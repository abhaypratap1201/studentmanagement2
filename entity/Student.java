package com.example.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "students")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String course;

    private double programmingScore;
    private double mathematicsScore;

    @ElementCollection
    private List<String> skills;

    public double getAverage() {
        return (programmingScore + mathematicsScore) / 2;
    }
}