package com.tnsif.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnsif.entities.Company;

/**
 * Repository interface for Company entity.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}