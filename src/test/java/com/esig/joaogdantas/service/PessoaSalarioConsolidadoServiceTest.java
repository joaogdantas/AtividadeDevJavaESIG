package com.esig.joaogdantas.service;

import com.esig.joaogdantas.model.cargo.Cargo;
import com.esig.joaogdantas.model.relacoes.CargoVencimentos;
import com.esig.joaogdantas.model.vencimentos.Vencimentos;
import com.esig.joaogdantas.repository.PessoaSalarioConsolidadoRepositorio;
import org.junit.Before;


import com.esig.joaogdantas.model.pessoa.Pessoa;
import com.esig.joaogdantas.repository.CargoVencimentosRepositorio;
import com.esig.joaogdantas.repository.PessoaRepositorio;
import com.esig.joaogdantas.util.EntityManagerProducer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.Test;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class PessoaSalarioConsolidadoServiceTest {

	@Inject
    private EntityManager manager;

	@Inject
    private PessoaRepositorio pessoaRepositorio;

	@Inject
	private Pessoa pessoa;
	@Inject
	private Cargo cargo;
	@Inject
	private Vencimentos vencimentos;
	@Inject
	private CargoVencimentos cargoVencimentos;
	@Inject
	private PessoaSalarioConsolidadoService pessoaSalarioConsolidadoService;

	@Before
	public void prepararAmbiente() {
		manager = new EntityManagerProducer().createEntityManager();
		pessoaRepositorio = new PessoaRepositorio(manager);
		Cargo cargo1 = new Cargo();
		pessoaSalarioConsolidadoService = new PessoaSalarioConsolidadoService();
	}

	@Test
    @Transactional
    public void testCalcularSalario() {
		Optional<Pessoa> pessoaTeste = pessoaRepositorio.findById(1);

		Integer salarioEsperado = 639;

        if(pessoaTeste.isPresent()) {
            Integer salarioCalculado = pessoaSalarioConsolidadoService.calcularSalario(pessoaTeste.get());
            assertEquals(salarioEsperado, salarioCalculado);
        }
    }
}