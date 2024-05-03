package com.esig.joaogdantas.model.pessoa;

import com.esig.joaogdantas.model.cargo.Cargo;

import jakarta.persistence.*;

@Entity(name = "pessoa")
@Table(name = "pessoa")
public class Pessoa {
	@Id
	@Column(name = "id", nullable = false, unique = true)
    private Integer id;
	
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    
    @Column(name = "cidade", nullable = false, length = 50)
    private String cidade;
    
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    
    @Column(name = "cep", nullable = false, length = 20)
    private String cep;
    
    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;
    
    @Column(name = "pais", nullable = false, length = 50)
    private String pais;
    
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;
    
    @Column(name = "data_nascimento", nullable = false, length = 20)
    private String dataNascimento;
    
    @ManyToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String cidade, String email, String cep, String endereco, String pais, String usuario, String telefone, String dataNascimento, Cargo cargo) {
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

	public Pessoa(Integer id, String nome, String cidade, String email, String cep, String endereco, String pais, String usuario, String telefone, String dataNascimento, Integer cargoId) {
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public Integer getCargoId() {
		return cargo.getId();
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
