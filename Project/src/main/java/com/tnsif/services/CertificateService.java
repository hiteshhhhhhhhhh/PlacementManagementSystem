package com.tnsif.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.entities.Certificate;
import com.tnsif.exceptions.EntityNotFoundException;
import com.tnsif.repositories.CertificateRepository;

import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service class for Certificate entity.
 */
@Service
@Transactional
public class CertificateService {

    @Autowired
    private CertificateRepository repo;

    public List<Certificate> listAll() {
        return repo.findAll();
    }

    public Certificate get(Integer id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Certificate not found with ID: " + id));
    }

    public Certificate save(Certificate certificate) {
        return repo.save(certificate);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Certificate not found with ID: " + id);
        }
        repo.deleteById(id);
    }

	public List<Certificate> getAllCertificates() {
		// TODO Auto-generated method stub
		return null;
	}
}

