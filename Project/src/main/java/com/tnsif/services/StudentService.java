package com.tnsif.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

import com.tnsif.entities.Student;
import com.tnsif.exceptions.EntityNotFoundException;
import com.tnsif.repositories.StudentRepository;

/**
 * Service class for managing Student entities.
 * 
 * This class provides business logic for handling Student operations,
 * including retrieving, saving, and deleting students.
 */
@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository repo;

    /**
     * Retrieves a list of all students.
     *
     * @return a list of Student entities
     */
    public List<Student> listAll() {
        return repo.findAll();
    }

    /**
     * Retrieves a student by its ID.
     *
     * @param id the ID of the student to be retrieved
     * @return the Student entity with the specified ID
     * @throws EntityNotFoundException if the student is not found
     */
    public Student get(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + id));
    }

    /**
     * Saves a student entity to the database.
     *
     * @param student the Student entity to be saved
     * @return the saved Student entity
     */
    public Student save(Student student) {
        return repo.save(student);
    }

    /**
     * Deletes a student by its ID.
     *
     * @param id the ID of the student to be deleted
     * @throws EntityNotFoundException if the student is not found
     */
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}
