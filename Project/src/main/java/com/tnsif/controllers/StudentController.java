package com.tnsif.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.entities.Student;
import com.tnsif.services.StudentService;

import java.util.List;

/**
 * REST Controller for Student operations.
 */
@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Retrieve all students.
     *
     * @return List of students
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.listAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * Add a new student.
     *
     * @param student Student to be added
     * @return Response message
     */
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>("Student added successfully", HttpStatus.CREATED);
    }

    /**
     * Retrieve a student by ID.
     *
     * @param id Student ID
     * @return Student details
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        try {
            Student student = studentService.get(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update an existing student.
     *
     * @param student Updated student details
     * @param id      Student ID
     * @return Response message
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        try {
            student.setId(id);
            studentService.save(student);
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a student by ID.
     *
     * @param id Student ID
     * @return Response message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        try {
            studentService.delete(id);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
