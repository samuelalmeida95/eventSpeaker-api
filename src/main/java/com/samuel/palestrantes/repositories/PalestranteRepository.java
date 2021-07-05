package com.samuel.palestrantes.repositories;

import com.samuel.palestrantes.models.Palestrante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PalestranteRepository extends JpaRepository<Palestrante, Long> {
    
}
