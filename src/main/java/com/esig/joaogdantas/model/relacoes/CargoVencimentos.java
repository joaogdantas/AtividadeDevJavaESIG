package com.esig.joaogdantas.model.relacoes;

import com.esig.joaogdantas.model.cargo.Cargo;


import com.esig.joaogdantas.model.vencimentos.Vencimentos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "cargo_vencimentos")
@Table(name = "cargo_vencimentos")
public class CargoVencimentos {
	@Id
	@Column(name = "id", nullable = false, unique = true)
    private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;
	
	@ManyToOne
    @JoinColumn(name = "vencimento_id", referencedColumnName = "id")
    private Vencimentos vencimento;

	public CargoVencimentos() {
	}
	
	public CargoVencimentos(Integer id, Cargo cargo, Vencimentos vencimento) {
		this.id = id;
		this.cargo = cargo;
		this.vencimento = vencimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Vencimentos getVencimentos() {
		return vencimento;
	}

	public Integer getVencimentoId() {
		return vencimento.getId();
	}
	
	public void setVencimentos(Vencimentos vencimentos) {
		this.vencimento = vencimentos;
	}
}
