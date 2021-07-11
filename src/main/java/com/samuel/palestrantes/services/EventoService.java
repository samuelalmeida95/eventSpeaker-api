package com.samuel.palestrantes.services;

import java.util.List;
import java.util.Optional;

import com.samuel.palestrantes.models.Evento;
import com.samuel.palestrantes.repositories.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> findAll(){
        return eventoRepository.findAll();
    }

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento findById(Long idEvento) {
        Optional<Evento> eventoBuscado = eventoRepository.findById(idEvento);
        return eventoBuscado.get();
    }

    public void deleteEvento(Long idEvento) {
        eventoRepository.deleteById(idEvento);
    }
}
