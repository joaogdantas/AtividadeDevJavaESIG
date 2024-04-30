package com.esig.joaogdantas.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.esig.joaogdantas.model.pessoa.Pessoa;
import com.esig.joaogdantas.model.relacoes.CargoVencimentos;
import com.esig.joaogdantas.model.vencimentos.*;
import com.esig.joaogdantas.repository.CargoVencimentosRepositorio;
import com.esig.joaogdantas.repository.PessoaRepositorio;
import com.esig.joaogdantas.repository.PessoaSalarioConsolidadoRepositorio;

import jakarta.transaction.Transactional;

public class PessoaSalarioConsolidadoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PessoaRepositorio pessoaRepositorio;
    
    @Inject
    private PessoaSalarioConsolidadoRepositorio pessoaSalarioConsolidadoRepositorio;
    
    @Inject
    private CargoVencimentosRepositorio cargoVencimentosRepositorio;
    
    @Transactional
    public Float calcularSalario(Pessoa pessoa) {
        Float salario = 0.0f;

        List<Integer> vencimentoIds = pessoa.getCargo().getCargoVencimentos().stream()
                                        .map(cv -> cv.getVencimentos().getId())
                                        .collect(Collectors.toList());

        Map<Integer, Vencimentos> vencimentosMap = cargoVencimentosRepositorio.findAll().stream()
                .map(CargoVencimentos::getVencimentos)
                .collect(Collectors.toMap(Vencimentos::getId, v -> v));

     
        for (Integer vencimentoId : vencimentoIds) {
            Vencimentos vencimento = vencimentosMap.get(vencimentoId);
            if (vencimento != null) {
                if (vencimento.getTipo() == TipoVencimento.CREDITO) {
                    salario += vencimento.getValor();
                } else if (vencimento.getTipo() == TipoVencimento.DEBITO) {
                    salario -= vencimento.getValor();
                }
            }
        }
        return salario;
    }

}
