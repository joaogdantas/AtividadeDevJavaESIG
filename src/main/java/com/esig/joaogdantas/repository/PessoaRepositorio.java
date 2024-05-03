package com.esig.joaogdantas.repository;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.esig.joaogdantas.model.pessoa.Pessoa;

import com.esig.joaogdantas.model.relacoes.PessoaSalarioConsolidado;
import com.esig.joaogdantas.service.PessoaSalarioConsolidadoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

public class PessoaRepositorio {

	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	@PersistenceContext
	private EntityManager manager;

	public PessoaRepositorio() {
	}

	public PessoaRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	@Transactional
	public Pessoa create(Pessoa pessoa) {
		logger.info("Consolidando salário para " + pessoa.getNome());
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();

		return pessoa;
	}

	public List<Pessoa> findAll() {
		logger.info("Buscando todas as pessoas e salários");
		return manager.createQuery("SELECT p FROM pessoa p", Pessoa.class).getResultList();
	}

	public Optional<Pessoa> findById(Integer id) {
		logger.info("Buscando pessoas e salários pelo id " + id);
		return Optional.ofNullable(manager.find(Pessoa.class, id));
	}

	public void delete(Integer id) {
		logger.info("Deletando pessoa salário pelo id " + id);
		Pessoa pessoa = findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
		manager.remove(pessoa);
	}

	public Pessoa update(Pessoa pessoa) {
		logger.info("Atualizando pessoa salário para " + pessoa.getNome());
		return manager.merge(pessoa);
	}

}
