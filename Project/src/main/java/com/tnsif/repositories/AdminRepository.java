package com.tnsif.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnsif.entities.Admin;

/**
 * Repository interface for Admin entity.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}