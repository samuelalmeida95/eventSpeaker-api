package com.samuel.palestrantes.controllers;

import com.samuel.palestrantes.models.Palestrante;
import com.samuel.palestrantes.services.PalestranteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/palestrantes")
public class PalestranteController {

  @Autowired
  private PalestranteService palestranteService;

  @GetMapping
  public ResponseEntity<List<Palestrante>> findAll() {
    return ResponseEntity.ok().body(palestranteService.findAll());
  }

  @PostMapping
  public ResponseEntity<Palestrante> salvar(
    @RequestBody Palestrante palestrante
  ) {
    palestranteService.save(palestrante);
    return new ResponseEntity<Palestrante>(HttpStatus.CREATED);
  }

  @PutMapping(value = "/atribuir-evento")
  public ResponseEntity<Palestrante> adicionarEvento(
    @RequestParam Long idPalestrante,
    @RequestParam Long idEvento
  ) {
    palestranteService.adicionarEvento(idPalestrante, idEvento);
    return new ResponseEntity<Palestrante>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
      palestranteService.delete(id);
      return ResponseEntity.noContent().build();
  }
}
