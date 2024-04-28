package com.esig.joaogdantas.model.cargo;

import com.esig.joaogdantas.model.pessoa.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "cargo")
@Table(name = "cargo")
public class Cargo {
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @OneToOne(mappedBy = "cargo")
    private Pessoa pessoa;

    public Cargo() {
    }

    public Cargo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

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
}
