package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // 1. Add Student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // 2. Retrieve All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // 3. Search By ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // 4. Update Scores and Skills
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        return service.updateStudent(id, student);
    }

    // 5. Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student Deleted Successfully!";
    }

    // 6. Merit List
    @GetMapping("/merit-list")
    public List<Student> meritList() {
        return service.getMeritList();
    }
}