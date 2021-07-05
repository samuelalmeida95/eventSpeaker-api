package com.samuel.palestrantes.controllers;

import com.samuel.palestrantes.models.Evento;
import com.samuel.palestrantes.services.EventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/eventos")
public class EventoController {

  @Autowired
  private EventoService eventoService;

  @GetMapping(value = "{idEvento}")
  public ResponseEntity<Evento> findById(@PathVariable Long idEvento) {
    return ResponseEntity.ok().body(eventoService.findById(idEvento));
  }

  @GetMapping
  public ResponseEntity<List<Evento>> findAll() {
    return ResponseEntity.ok().body(eventoService.findAll());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Evento> salvar(@RequestBody Evento evento) {
    Evento eventoParaSalvar = eventoService.save(evento);
    return new ResponseEntity<>(eventoParaSalvar, HttpStatus.CREATED);
  }
}
