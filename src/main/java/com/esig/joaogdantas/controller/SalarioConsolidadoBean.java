package com.esig.joaogdantas.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.esig.joaogdantas.model.cargo.Cargo;
import com.esig.joaogdantas.model.pessoa.Pessoa;
import com.esig.joaogdantas.model.relacoes.PessoaSalarioConsolidado;
import com.esig.joaogdantas.repository.PessoaRepositorio;
import com.esig.joaogdantas.repository.PessoaSalarioConsolidadoRepositorio;
import com.esig.joaogdantas.service.PessoaSalarioConsolidadoService;
import com.esig.joaogdantas.util.EntityManagerProducer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
@ViewScoped
@ManagedBean
public class SalarioConsolidadoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    @Inject
    private PessoaSalarioConsolidadoRepositorio pessoaSalarioConsolidadoRepositorio;

    @Inject
    private PessoaSalarioConsolidadoService pessoaSalarioConsolidadoService;

    private List<PessoaSalarioConsolidado> listaPessoasSalariosConsolidados;

    @Inject
    private Pessoa pessoa;

    @Inject
    private Cargo cargo;

    public void pessoasCadastradas(){
        EntityManager manager = new EntityManagerProducer().createEntityManager();
        pessoaSalarioConsolidadoRepositorio = new PessoaSalarioConsolidadoRepositorio(manager);

        listaPessoasSalariosConsolidados = pessoaSalarioConsolidadoRepositorio.findAll();
    }
    public List<PessoaSalarioConsolidado> getListaPessoasSalariosConsolidados(){
        return listaPessoasSalariosConsolidados;
    }

    public void calcularERegistrarSalarios(){
        try {

            EntityManager manager = new EntityManagerProducer().createEntityManager();
            pessoaSalarioConsolidadoService = new PessoaSalarioConsolidadoService();
            pessoaSalarioConsolidadoRepositorio = new PessoaSalarioConsolidadoRepositorio(manager);

            pessoaSalarioConsolidadoService.calcularERegistrarSalarios();
        } catch (Exception e){
            FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Valores já cadastrados."));
        }
    }
}
