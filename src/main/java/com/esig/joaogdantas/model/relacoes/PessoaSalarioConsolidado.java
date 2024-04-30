package com.esig.joaogdantas.model.relacoes;

import com.esig.joaogdantas.model.cargo.Cargo;
import com.esig.joaogdantas.model.pessoa.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity(name = "pessoa_salario_consolidado")
@Table(name = "pessoa_salario_consolidado")
public class PessoaSalarioConsolidado {
    @OneToOne 
    @Transient
    private Cargo cargo;
    
    @OneToOne 
    @Transient
    private Pessoa pessoa;
    
    @Column(name = "pessoa_id", nullable = false)
    private Integer pessoaId;

    @Column(name = "nome_pessoa", nullable = false)
    private String nomePessoa;
    		
    @Column(name = "nome_cargo", nullable = false)
    private String nomeCargo;
    
    @Column(name = "salario", nullable = false)
    private Float salario;

	public PessoaSalarioConsolidado() {
	}
	
	public PessoaSalarioConsolidado(Cargo cargo, Pessoa pessoa, Integer pessoaId, String nomePessoa, String nomeCargo, Float salario) {
		this.cargo = cargo;
		this.pessoa = pessoa;
		this.pessoaId = pessoaId;
		this.nomePessoa = nomePessoa;
		this.nomeCargo = nomeCargo;
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}
}
