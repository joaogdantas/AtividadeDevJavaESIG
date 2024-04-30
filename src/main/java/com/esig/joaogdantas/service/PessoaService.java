package com.esig.joaogdantas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.esig.joaogdantas.model.pessoa.Pessoa;
import com.esig.joaogdantas.repository.PessoaRepositorio;

import jakarta.transaction.Transactional;

public class PessoaService implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Inject
    private PessoaRepositorio pessoaRepositorio;

    @Transactional
    public void novaPessoa(Pessoa pessoa) {
        pessoaRepositorio.save(pessoa);
    }

    @Transactional
    public void excluir(Integer id) {
    	pessoaRepositorio.deleteById(id);
    }
}
