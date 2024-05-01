package com.esig.joaogdantas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.esig.joaogdantas.model.cargo.Cargo;
import com.esig.joaogdantas.model.pessoa.Pessoa;
import com.esig.joaogdantas.model.relacoes.CargoVencimentos;
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
    private EntityManager manager;
    
    @Inject
    private PessoaRepositorio pessoaRepositorio;
    
    @Inject
    private PessoaSalarioConsolidadoRepositorio pessoaSalarioConsolidadoRepositorio;
    
    @Inject
    private CargoVencimentosRepositorio cargoVencimentosRepositorio;
    
    @Transactional
    public Float calcularSalario(Pessoa pessoa) {
		manager = new EntityManagerProducer().createEntityManager();
		cargoVencimentosRepositorio = new CargoVencimentosRepositorio(manager);

        Float salario = 0.0f;

        Cargo cargo = pessoa.getCargo();
        if (cargo == null) {
            return salario;
        }
        
        for (CargoVencimentos cv : cargo.getCargoVencimentos()) {
            Vencimentos vencimento = cv.getVencimentos();
            if (vencimento != null) {
                if ("CREDITO".equals(vencimento.getTipo())) {
                    salario += vencimento.getValor();
                } else if ("DEBITO".equals(vencimento.getTipo())) {
                    salario -= vencimento.getValor();
                }
            }
        }     
        return salario;
    }
}
