package com.esig.joaogdantas.repository;

import javax.inject.Inject;

import com.esig.joaogdantas.model.pessoa.Pessoa;
import com.esig.joaogdantas.model.relacoes.PessoaSalarioConsolidado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class PessoaSalarioConsolidadoRepositorio {

	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	@PersistenceContext
	private EntityManager manager;

	public PessoaSalarioConsolidadoRepositorio() {
	}

	public PessoaSalarioConsolidadoRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	@Transactional
	public PessoaSalarioConsolidado create(PessoaSalarioConsolidado pessoaSalarioConsolidado) {
		logger.info("Consolidando salário para " + pessoaSalarioConsolidado.getPessoa().getNome());
		manager.getTransaction().begin();
		manager.persist(pessoaSalarioConsolidado);
		manager.getTransaction().commit();

		return pessoaSalarioConsolidado;
	}

	public List<PessoaSalarioConsolidado> findAll() {
		logger.info("Buscando todas as pessoas e salários");
		return manager.createQuery("SELECT p FROM pessoa_salario_consolidado p", PessoaSalarioConsolidado.class).getResultList();
	}

	public Optional<PessoaSalarioConsolidado> findById(Integer id) {
		logger.info("Buscando pessoas e salários pelo id " + id);
		return Optional.ofNullable(manager.find(PessoaSalarioConsolidado.class, id));
	}

	public void delete(Integer id) {
		logger.info("Deletando pessoa salário pelo id " + id);
		PessoaSalarioConsolidado pessoaSalarioConsolidado = findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
		manager.remove(pessoaSalarioConsolidado);
	}

	public PessoaSalarioConsolidado update(PessoaSalarioConsolidado pessoaSalarioConsolidado) {
		logger.info("Atualizando pessoa salário para " + pessoaSalarioConsolidado.getPessoa().getNome());
		return manager.merge(pessoaSalarioConsolidado);
	}
}
