package com.tnsif.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnsif.entities.Placement;

/**
 * Repository interface for Placement entity.
 */
@Repository
public interface PlacementRepository extends JpaRepository<Placement, Integer> {
}