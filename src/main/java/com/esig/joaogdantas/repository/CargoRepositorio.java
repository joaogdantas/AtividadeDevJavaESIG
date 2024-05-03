package com.esig.joaogdantas.repository;

import com.esig.joaogdantas.model.cargo.Cargo;
import com.esig.joaogdantas.model.pessoa.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.inject.Inject;

public class CargoRepositorio {

    @PersistenceContext
    private EntityManager manager;

    public CargoRepositorio() {
    }

    public CargoRepositorio(EntityManager manager) {
        this.manager = manager;
    }
}
