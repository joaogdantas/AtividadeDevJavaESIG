package com.esig.joaogdantas.model.relacoes;

import com.esig.joaogdantas.model.cargo.Cargo;

import com.esig.joaogdantas.model.pessoa.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "pessoas_salarios_consolidado")
@Table(name = "pessoa_salario_consolidado")
public class PessoaSalarioConsolidado { 
    @Id
    @OneToOne 
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private Pessoa pessoa;
    
    @Column(name = "nome_pessoa", nullable = false)
    private String nomePessoa;
    
    @OneToOne
    @JoinColumn(name = "nome_cargo",  referencedColumnName = "nome")
    private Cargo cargo;
    
    @Column(name = "salario", nullable = false)
    private Float salario;

	public PessoaSalarioConsolidado() {
	}

	public PessoaSalarioConsolidado(Pessoa pessoa, String nomePessoa, Cargo cargo, Float salario) {
		super();
		this.pessoa = pessoa;
		this.nomePessoa = nomePessoa;
		this.cargo = cargo;
		this.salario = salario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNomePessoa() {
		return pessoa.getNome();
	}

	public void setNomePessoa() {
		this.nomePessoa = pessoa.getNome();
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}
	

}
