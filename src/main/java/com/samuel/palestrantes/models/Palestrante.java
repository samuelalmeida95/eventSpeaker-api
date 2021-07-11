package com.samuel.palestrantes.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Palestrante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String senha;
  private boolean admin;

  @ManyToMany
  @JoinTable(
    name = "tb_palestrante_evento",
    joinColumns = @JoinColumn(name = "palestrante_id"),
    inverseJoinColumns = @JoinColumn(name = "evento_id")
  )
  private Set<Evento> eventos = new HashSet<>();

  public Palestrante(Long id, String nome, String senha) {
    this.id = id;
    this.nome = nome;
    this.senha = senha;
    this.admin = false;
  }

  public Palestrante() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public void addEventos(Evento evento) {
    this.eventos.add(evento);
  }

  public void removerEventos(Object evento){
    this.eventos.remove(evento);
  }

  public Set<Evento> getEventos() {
    return this.eventos;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Palestrante)) return false;
    Palestrante other = (Palestrante) obj;
    return Objects.equals(id, other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
