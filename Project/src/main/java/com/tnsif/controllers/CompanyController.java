package com.tnsif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.entities.Company;
import com.tnsif.services.CompanyService;

import java.util.List;

/**
 * REST Controller for Company operations.
 */
@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * Retrieve all companies.
     *
     * @return List of companies
     */
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.listAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    /**
     * Add a new company.
     *
     * @param company Company to be added
     * @return Response message
     */
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.save(company);
        return new ResponseEntity<>("Company added successfully", HttpStatus.CREATED);
    }

    /**
     * Retrieve a company by ID.
     *
     * @param id Company ID
     * @return Company details
     */
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Integer id) {
        try {
            Company company = companyService.get(id);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update an existing company.
     *
     * @param company Updated company details
     * @param id      Company ID
     * @return Response message
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable Integer id) {
        try {
            // Optional: Check if the company exists before updating
            company.setId(id);
            companyService.save(company);
            return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a company by ID.
     *
     * @param id Company ID
     * @return Response message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Integer id) {
        try {
            companyService.delete(id);
            return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
