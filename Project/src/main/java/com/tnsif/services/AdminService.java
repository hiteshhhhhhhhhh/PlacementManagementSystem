package com.tnsif.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.tnsif.entities.Admin;
import com.tnsif.exceptions.EntityNotFoundException;
import com.tnsif.repositories.AdminRepository;

import java.util.List;

/**
 * Service class for Admin entity.
 */
@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepository repo;

    /**
     * Retrieves all admins.
     *
     * @return a list of admins
     */
    public List<Admin> listAll() {
        return repo.findAll();
    }

    /**
     * Retrieves an admin by ID.
     *
     * @param id the ID of the admin
     * @return the admin entity
     * @throws EntityNotFoundException if the admin is not found
     */
    public Admin get(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found with ID: " + id));
    }

    /**
     * Saves an admin entity.
     *
     * @param admin the admin to be saved
     * @return the saved admin entity
     */
    public Admin save(Admin admin) {
        return repo.save(admin);
    }

    /**
     * Deletes an admin by ID.
     *
     * @param id the ID of the admin to be deleted
     * @throws EntityNotFoundException if the admin is not found
     */
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Admin not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}
