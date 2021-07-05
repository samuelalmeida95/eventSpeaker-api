package com.samuel.palestrantes.repositories;

import com.samuel.palestrantes.models.Evento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
