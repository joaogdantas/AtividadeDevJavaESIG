package com.esig.joaogdantas.repository;

import java.util.List;


import javax.inject.Inject;

import com.esig.joaogdantas.model.relacoes.CargoVencimentos;

import jakarta.persistence.EntityManager;

public class CargoVencimentosRepositorio {

	@Inject
	private EntityManager manager;

	public CargoVencimentosRepositorio() {
	}

	public CargoVencimentosRepositorio(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<CargoVencimentos> findAll() {
        return manager.createQuery("from cargo_vencimentos", CargoVencimentos.class).getResultList();
   }
}
