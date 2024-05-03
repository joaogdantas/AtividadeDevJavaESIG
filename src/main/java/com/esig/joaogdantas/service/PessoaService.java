package com.esig.joaogdantas.service;

import java.io.Serializable;
import java.util.Optional;

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
        pessoaRepositorio.create(pessoa);
    }

    @Transactional
    public void deletarPessoa(Integer id) {
    	pessoaRepositorio.delete(id);
    }

    public void atualizarPessoa(Integer id) {
        Optional<Pessoa> registroPessoa = pessoaRepositorio.findById(id);
        if (registroPessoa.isPresent()) {
            pessoaRepositorio.update(registroPessoa.get());
        }
    }
}
