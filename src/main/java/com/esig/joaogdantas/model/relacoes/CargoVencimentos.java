package com.esig.joaogdantas.model.relacoes;

import com.esig.joaogdantas.model.cargo.Cargo;

import com.esig.joaogdantas.model.vencimentos.Vencimentos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity(name = "cargo_vencimentos")
@Table(name = "cargo_vencimentos")
public class CargoVencimentos {
	@Column(name = "id", nullable = false, unique = true)
    private Integer id;
	@OneToOne
	@Transient
    private Cargo cargo;
	@OneToOne
    @Transient
    private Vencimentos vencimentos;
	@Column(name = "cargo_id", nullable = false)
    private Integer cargoId;
	@Column(name = "vencimento_id", nullable = false)
    private Integer vencimentoId;

	public CargoVencimentos() {
	}
	
	public CargoVencimentos(Integer id, Cargo cargo, Vencimentos vencimentos) {
		this.id = id;
		this.cargo = cargo;
		this.vencimentos = vencimentos;
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

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Vencimentos getVencimentos() {
		return vencimentos;
	}

	public void setVencimentos(Vencimentos vencimentos) {
		this.vencimentos = vencimentos;
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}

	public Integer getVencimentoId() {
		return vencimentoId;
	}

	public void setVencimentoId(Integer vencimentoId) {
		this.vencimentoId = vencimentoId;
	}


}
