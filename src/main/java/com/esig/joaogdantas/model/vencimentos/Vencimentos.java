package com.esig.joaogdantas.model.vencimentos;

import java.util.List;

import com.esig.joaogdantas.model.relacoes.CargoVencimentos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "vencimentos")
@Table(name = "vencimentos")
public class Vencimentos {
	@Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "descricao", nullable = false, length = 5000)
    private String descricao;
    @Column(name = "valor", nullable = false)
    private Float valor;
    @Column(name = "tipo", nullable = false)
    private TipoVencimento tipo;
    @OneToMany(mappedBy = "vencimentos")
    List<CargoVencimentos> cargoVencimentos;
    
	public Vencimentos() {
	}

	public Vencimentos(Integer id, String descricao, Float valor, TipoVencimento tipo) {
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

	public TipoVencimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoVencimento tipo) {
		this.tipo = tipo;
	}

	public List<CargoVencimentos> getCargoVencimentos() {
		return cargoVencimentos;
	}

	public void setCargoVencimentos(List<CargoVencimentos> cargoVencimentos) {
		this.cargoVencimentos = cargoVencimentos;
	}
}
