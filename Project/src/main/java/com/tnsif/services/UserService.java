package com.tnsif.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

import com.tnsif.entities.User;
import com.tnsif.exceptions.EntityNotFoundException;
import com.tnsif.repositories.UserRepository;

/**
 * Service class for managing User entities.
 * 
 * This class provides business logic for handling User operations,
 * including retrieving, saving, and deleting users.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    /**
     * Retrieves a list of all users.
     *
     * @return a list of User entities
     */
    public List<User> listAll() {
        return repo.findAll();
    }

    /**
     * Saves a user entity to the database.
     *
     * @param user the User entity to be saved
     * @return the saved User entity
     */
    public User save(User user) {
        return repo.save(user);
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id the ID of the user to be retrieved
     * @return the User entity with the specified ID
     * @throws EntityNotFoundException if the user is not found
     */
    public User get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id the ID of the user to be deleted
     * @throws EntityNotFoundException if the user is not found
     */
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}
