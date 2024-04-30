package com.esig.joaogdantas.repository;

import javax.inject.Inject;

import jakarta.persistence.EntityManager;

public class PessoaSalarioConsolidadoRepositorio {

	@Inject
	private EntityManager manager;

	public PessoaSalarioConsolidadoRepositorio() {
	}

	public PessoaSalarioConsolidadoRepositorio(EntityManager manager) {
		this.manager = manager;
	}
	
}
