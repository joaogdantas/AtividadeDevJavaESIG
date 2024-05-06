package com.esig.joaogdantas.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import com.esig.joaogdantas.model.cargo.Cargo;
import com.esig.joaogdantas.model.pessoa.Pessoa;
import com.esig.joaogdantas.model.relacoes.CargoVencimentos;
import com.esig.joaogdantas.model.relacoes.PessoaSalarioConsolidado;
import com.esig.joaogdantas.model.vencimentos.*;
import com.esig.joaogdantas.repository.CargoVencimentosRepositorio;
import com.esig.joaogdantas.repository.PessoaRepositorio;
import com.esig.joaogdantas.repository.PessoaSalarioConsolidadoRepositorio;
import com.esig.joaogdantas.util.EntityManagerProducer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class PessoaSalarioConsolidadoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    @Inject
    private EntityManager entityManager;

    @Inject
    private PessoaSalarioConsolidado pessoaSalarioConsolidado;

    @Inject
    private PessoaRepositorio pessoaRepositorioInject;
    
    @Inject
    private PessoaSalarioConsolidadoRepositorio pessoaSalarioConsolidadoRepositorioInject;
    
    @Inject
    private CargoVencimentosRepositorio cargoVencimentosRepositorioInject;

    EntityManager manager = new EntityManagerProducer().createEntityManager();
    PessoaRepositorio pessoaRepositorio = new PessoaRepositorio(manager);
    PessoaSalarioConsolidadoRepositorio pessoaSalarioConsolidadoRepositorio = new PessoaSalarioConsolidadoRepositorio(manager);
    CargoVencimentosRepositorio cargoVencimentosRepositorio = new CargoVencimentosRepositorio(manager);


    @Transactional
    public void calcularERegistrarSalarios() {
        List<Pessoa> pessoas = pessoaRepositorio.findAll();

            pessoas.forEach(pessoa -> {
                Integer salario = calcularSalario(pessoa);
                registrarSalarioConsolidado(pessoa, pessoa.getCargo(), salario);
            });
        }

    @Transactional
    private void registrarSalarioConsolidado(Pessoa pessoa, Cargo cargo, Integer salario) {
        PessoaSalarioConsolidado novaPessoaSalarioConsolidado = new PessoaSalarioConsolidado(pessoa, cargo, salario);

        pessoaSalarioConsolidadoRepositorio.create(novaPessoaSalarioConsolidado);
    }

    @Transactional
    public Integer calcularSalario(Pessoa pessoa) {
        Integer salario = 0;

        Cargo cargo = pessoa.getCargo();
        if (cargo == null) {
            return salario;
        }

        salario = cargo.getCargoVencimentos().stream()
                .map(CargoVencimentos::getVencimentos)
                .filter(Objects::nonNull)
                .filter(vencimento -> "CREDITO".equals(vencimento.getTipo()) || "DEBITO".equals(vencimento.getTipo()))
                .mapToInt(vencimento -> "CREDITO".equals(vencimento.getTipo()) ? vencimento.getValor() : -vencimento.getValor())
                .sum();

        return salario;
    }
}
