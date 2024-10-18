package com.tnsif.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

import com.tnsif.entities.Company;
import com.tnsif.exceptions.EntityNotFoundException;
import com.tnsif.repositories.CompanyRepository;

/**
 * Service class for managing Company entities.
 * 
 * This class provides business logic for handling Company operations,
 * including retrieving, saving, and deleting companies.
 */
@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository repo;

    /**
     * Retrieves a list of all companies.
     *
     * @return a list of Company entities
     */
    public List<Company> listAll() {
        return repo.findAll();
    }

    /**
     * Retrieves a company by its ID.
     *
     * @param id the ID of the company to be retrieved
     * @return the Company entity with the specified ID
     * @throws EntityNotFoundException if the company is not found
     */
    public Company get(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + id));
    }

    /**
     * Saves a company entity to the database.
     *
     * @param company the Company entity to be saved
     * @return the saved Company entity
     */
    public Company save(Company company) {
        return repo.save(company);
    }

    /**
     * Deletes a company by its ID.
     *
     * @param id the ID of the company to be deleted
     * @throws EntityNotFoundException if the company is not found
     */
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Company not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}
