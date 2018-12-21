package com.kg.registration.repository;

import com.kg.registration.model.Register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TeamRepository
 */
@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    
}