package com.esig.joaogdantas.model.pessoa;

import com.esig.joaogdantas.model.cargo.Cargo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "pessoa")
@Table(name = "pessoa")
public class Pessoa {
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "email")
    private String email;
    @Column(name = "cep")
    private String cep;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "pais")
    private String pais;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "data_nascimento")
    private Date data_Nascimento;
    @OneToOne
    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
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
