package com.tnsif.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnsif.entities.Certificate;

/**
 * Repository interface for Certificate entity.
 */
@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
}