package com.tnsif.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

import com.tnsif.entities.Placement;
import com.tnsif.exceptions.EntityNotFoundException;
import com.tnsif.repositories.PlacementRepository;

/**
 * Service class for managing Placement entities.
 * 
 * This class provides business logic for handling Placement operations,
 * including retrieving, saving, and deleting placements.
 */
@Service
@Transactional
public class PlacementService {

    @Autowired
    private PlacementRepository repo;

    /**
     * Retrieves a list of all placements.
     *
     * @return a list of Placement entities
     */
    public List<Placement> listAll() {
        return repo.findAll();
    }

    /**
     * Retrieves a placement by its ID.
     *
     * @param id the ID of the placement to be retrieved
     * @return the Placement entity with the specified ID
     * @throws EntityNotFoundException if the placement is not found
     */
    public Placement get(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Placement not found with ID: " + id));
    }

    /**
     * Saves a placement entity to the database.
     *
     * @param placement the Placement entity to be saved
     * @return the saved Placement entity
     */
    public Placement save(Placement placement) {
        return repo.save(placement);
    }

    /**
     * Deletes a placement by its ID.
     *
     * @param id the ID of the placement to be deleted
     * @throws EntityNotFoundException if the placement is not found
     */
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Placement not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}
