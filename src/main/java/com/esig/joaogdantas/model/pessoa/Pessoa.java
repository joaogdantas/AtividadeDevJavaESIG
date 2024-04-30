package com.esig.joaogdantas.model.pessoa;

import com.esig.joaogdantas.model.cargo.Cargo;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity(name = "pessoa")
@Table(name = "pessoa")
public class Pessoa {
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    @Column(name = "cidade", nullable = false, length = 50)
    private String cidade;
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Column(name = "cep", nullable = false, length = 15)
    private String cep;
    @Column(name = "endereco", nullable = false, length = 512)
    private String endereco;
    @Column(name = "pais", nullable = false, length = 50)
    private String pais;
    @Column(name = "usuario", nullable = false, length = 255, unique = true)
    private String usuario;
    @Column(name = "telefone", nullable = false, length = 20, unique = true)
    private String telefone;
    @Column(name = "data_nascimento", nullable = false, length = 255)
    private Date dataNascimento;
    @ManyToOne
    @Transient
    private Cargo cargo;
    @Column(name = "cargo_id", nullable = false)
    private Integer cargoId;
    
    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String cidade, String email, String cep, String endereco, String pais, String usuario, String telefone, Date dataNascimento, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.pais = pais;
        this.usuario = usuario;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}
}
