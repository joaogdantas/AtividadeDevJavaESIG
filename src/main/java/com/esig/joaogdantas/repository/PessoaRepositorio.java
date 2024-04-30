package com.esig.joaogdantas.repository;

import java.util.List;

import javax.inject.Inject;

import com.esig.joaogdantas.model.pessoa.Pessoa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class PessoaRepositorio {
	
	@Inject
	private EntityManager manager;

	public PessoaRepositorio() {
	}

	public PessoaRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	public Pessoa save(Pessoa pessoa) {
		return manager.merge(pessoa);
	}
	
	public Pessoa findById(Integer id) {
		return manager.find(Pessoa.class, id);
	}


	public List<Pessoa> findByName(String nome) {
		String jpql = "from Pessoa where nome like :nome";
		
		TypedQuery<Pessoa> query = manager
				.createQuery(jpql, Pessoa.class);
		
		query.setParameter("nome", nome + "%");
		
		return query.getResultList();
	}
	
	public List<Pessoa> findAll() {
         return manager.createQuery("from Pessoa", Pessoa.class).getResultList();
    }

	public void deleteById(Integer id) {
		Pessoa pessoa = findById(id);
		manager.remove(pessoa);
	}

}
