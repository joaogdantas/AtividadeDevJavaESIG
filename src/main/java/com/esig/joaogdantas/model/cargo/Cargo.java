package com.esig.joaogdantas.model.cargo;

import java.util.List;

import com.esig.joaogdantas.model.pessoa.Pessoa;
import com.esig.joaogdantas.model.relacoes.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "cargo")
@Table(name = "cargo")
public class Cargo {
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "nome", nullable = false, length = 255, unique = true)
    private String nome;
    @OneToMany(mappedBy = "cargo")
    private List<Pessoa> pessoa;
    @OneToOne(mappedBy = "cargo")
    private CargoVencimentos cargoVencimento;
    
    public Cargo() {
    }

    public Cargo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	public CargoVencimentos getCargoVencimento() {
		return cargoVencimento;
	}

	public void setCargoVencimento(CargoVencimentos cargoVencimento) {
		this.cargoVencimento = cargoVencimento;
	}
}
