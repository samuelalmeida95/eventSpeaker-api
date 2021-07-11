package com.samuel.palestrantes.services;

import com.samuel.palestrantes.models.Evento;
import com.samuel.palestrantes.models.Palestrante;
import com.samuel.palestrantes.repositories.PalestranteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalestranteService {

  @Autowired
  private PalestranteRepository palestranteRepository;

  @Autowired
  private EventoService eventoService;

  public List<Palestrante> findAll() {
    return palestranteRepository.findAll();
  }

  public Palestrante findById(Long idPalestrante) {
    Optional<Palestrante> palestranteBuscado = palestranteRepository.findById(
      idPalestrante
    );
    return palestranteBuscado.get();
  }

  public Palestrante save(Palestrante palestrante) {
    return palestranteRepository.save(palestrante);
  }

  public Palestrante adicionarEvento(Long idPalestrante, Long idEvento) {
    Palestrante palestranteAddEvento = findById(idPalestrante);
    Evento eventoParaAdicionar = eventoService.findById(idEvento);
    palestranteAddEvento.addEventos(eventoParaAdicionar);
    return palestranteRepository.save(palestranteAddEvento);
  }

  public void delete(Long idPalestrante) {
    palestranteRepository.deleteById(idPalestrante);
  }

  public void removerEvento(Long idPalestrante, Long idEvento) {
    Palestrante palestranteRemoveEvento = findById(idPalestrante);
    Evento eventoParaRemover = eventoService.findById(idEvento);
    palestranteRemoveEvento.removerEventos(eventoParaRemover);
    eventoService.deleteEvento(idEvento);
  }
}
