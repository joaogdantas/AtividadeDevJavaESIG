package com.esig.joaogdantas.model.relacoes;

import com.esig.joaogdantas.model.cargo.Cargo;

import com.esig.joaogdantas.model.pessoa.Pessoa;

import jakarta.persistence.*;

@Entity(name = "pessoa_salario_consolidado")
@Table(name = "pessoa_salario_consolidado")
public class PessoaSalarioConsolidado {
	@Id
	@OneToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;

	@Column(name = "nome_pessoa")
	private String nomePessoa;

	@OneToOne
	@JoinColumn(name = "nome_cargo", referencedColumnName = "nome")
	private Cargo cargo;

	@Column(name = "salario")
	private Integer salario;

	public PessoaSalarioConsolidado() {
	}

	public PessoaSalarioConsolidado(Pessoa pessoa, String nomePessoa, Cargo cargo, Integer salario) {
		this.pessoa = pessoa;
		this.nomePessoa = nomePessoa;
		this.cargo = cargo;
		this.salario = salario;
	}

	public PessoaSalarioConsolidado(Pessoa pessoa, Cargo cargo, Integer salario) {
		this.pessoa = pessoa;
		this.nomePessoa = pessoa.getNome();
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

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = pessoa.getNome();
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	

}
