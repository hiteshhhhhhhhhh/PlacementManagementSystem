package com.tnsif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.entities.Placement;
import com.tnsif.services.PlacementService;

import java.util.List;

/**
 * REST Controller for Placement operations.
 */
@RestController
@RequestMapping("/placements")
@CrossOrigin(origins = "http://localhost:3000")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    /**
     * Retrieve all placements.
     *
     * @return List of placements
     */
    @GetMapping
    public ResponseEntity<List<Placement>> getAllPlacements() {
        List<Placement> placements = placementService.listAll();
        return new ResponseEntity<>(placements, HttpStatus.OK);
    }

    /**
     * Add a new placement.
     *
     * @param placement Placement to be added
     * @return Response message
     */
    @PostMapping
    public ResponseEntity<String> addPlacement(@RequestBody Placement placement) {
        placementService.save(placement);
        return new ResponseEntity<>("Placement added successfully", HttpStatus.CREATED);
    }

    /**
     * Retrieve a placement by ID.
     *
     * @param id Placement ID
     * @return Placement details
     */
    @GetMapping("/{id}")
    public ResponseEntity<Placement> getPlacement(@PathVariable Integer id) {
        try {
            Placement placement = placementService.get(id);
            return new ResponseEntity<>(placement, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update an existing placement.
     *
     * @param placement Updated placement details
     * @param id       Placement ID
     * @return Response message
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlacement(@RequestBody Placement placement, @PathVariable Integer id) {
        try {
            placement.setId(id);
            placementService.save(placement);
            return new ResponseEntity<>("Placement updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a placement by ID.
     *
     * @param id Placement ID
     * @return Response message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlacement(@PathVariable Integer id) {
        try {
            placementService.delete(id);
            return new ResponseEntity<>("Placement deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
