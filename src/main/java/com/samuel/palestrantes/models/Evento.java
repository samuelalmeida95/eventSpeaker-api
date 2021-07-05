package com.samuel.palestrantes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Evento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String local;

  @JsonIgnore
  @ManyToMany(mappedBy = "eventos")
  private Set<Palestrante> palestrantes = new HashSet<>();

  public Evento(Long id, String nome, String local) {
    this.id = id;
    this.nome = nome;
    this.local = local;
  }

  public Evento() {}

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

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void addPalestrantes(Palestrante palestrante) {
    this.palestrantes.add(palestrante);
  }

  public Set<Palestrante> getPalestrantes(){
    return this.palestrantes;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Evento)) return false;
    Evento other = (Evento) obj;
    return Objects.equals(id, other.id);
  }
}
