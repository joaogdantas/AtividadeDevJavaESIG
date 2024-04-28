package com.esig.joaogdantas;

import com.esig.joaogdantas.model.Cargo.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity(name = "pessoa")
@Table(name = "pessoa")
public class Pessoa {
    @Column(name = "ID")
    private Long id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Cidade")
    private String cidade;
    @Column(name = "Email")
    private String email;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "Endereco")
    private String endereco;
    @Column(name = "Pais")
    private String pais;
    @Column(name = "Usuario")
    private String usuario;
    @Column(name = "Telefone")
    private String telefone;
    @Column(name = "Data_Nascimento")
    private Date data_Nascimento;
    @Column(name = "Cargo_ID")
    private Cargo cargo;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String cidade, String email, String cep, String endereco, String pais, String usuario, String telefone, Date data_Nascimento, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.pais = pais;
        this.usuario = usuario;
        this.telefone = telefone;
        this.data_Nascimento = data_Nascimento;
        this.cargo = cargo;
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

    public Date getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }
}
