package com.esig.joaogdantas.model.vencimentos;

import java.util.List;


import com.esig.joaogdantas.model.relacoes.CargoVencimentos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "vencimentos")
@Table(name = "vencimentos")
public class Vencimentos {
	@Id
	@Column(name = "id", nullable = false, unique = true)
    private Integer id;
	
    @Column(name = "descricao", nullable = false, length = 512)
    private String descricao;
    
    @Column(name = "valor", nullable = false)
    private Float valor;
    
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
    
    @OneToMany(mappedBy = "vencimento")
    List<CargoVencimentos> cargoVencimentos;
    
	public Vencimentos() {
	}

	public Vencimentos(Integer id, String descricao, Float valor, String tipo) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<CargoVencimentos> getCargoVencimentos() {
		return cargoVencimentos;
	}

	public void setCargoVencimentos(List<CargoVencimentos> cargoVencimentos) {
		this.cargoVencimentos = cargoVencimentos;
	}
}
