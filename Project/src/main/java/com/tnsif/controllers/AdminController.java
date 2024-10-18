package com.tnsif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tnsif.entities.Admin;
import com.tnsif.services.AdminService;
import java.util.List;

/**
 * REST Controller for Admin operations.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * Retrieve all admins.
     *
     * @return List of admins
     */
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.listAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    /**
     * Add a new admin.
     *
     * @param admin Admin to be added
     * @return Response message
     */
    @PostMapping
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
        adminService.save(admin);
        return new ResponseEntity<>("Admin added successfully", HttpStatus.CREATED);
    }

    /**
     * Retrieve an admin by ID.
     *
     * @param id Admin ID
     * @return Admin details
     */
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Integer id) {
        try {
            Admin admin = adminService.get(id);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update an existing admin.
     *
     * @param admin Updated admin details
     * @param id    Admin ID
     * @return Response message
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin, @PathVariable Integer id) {
        try {
            admin.setId(id);
            adminService.save(admin);
            return new ResponseEntity<>("Admin updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete an admin by ID.
     *
     * @param id Admin ID
     * @return Response message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Integer id) {
        try {
            adminService.delete(id);
            return new ResponseEntity<>("Admin deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
