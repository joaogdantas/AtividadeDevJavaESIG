package com.esig.joaogdantas.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.PrimeFaces;

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

    @PersistenceContext
    @Inject
    private EntityManager managerInject;

    @Inject
    private PessoaSalarioConsolidadoRepositorio pessoaSalarioConsolidadoRepositorioInject;

    @Inject
    private PessoaSalarioConsolidadoService pessoaSalarioConsolidadoServiceInject;

    private List<PessoaSalarioConsolidado> listaPessoasSalariosConsolidados;

    @Inject
    private Pessoa pessoa;

    @Inject
    private Cargo cargo;

    EntityManager manager = new EntityManagerProducer().createEntityManager();
    PessoaSalarioConsolidadoRepositorio pessoaSalarioConsolidadoRepositorio = new PessoaSalarioConsolidadoRepositorio(manager);
    PessoaSalarioConsolidadoService pessoaSalarioConsolidadoService = new PessoaSalarioConsolidadoService();

    public void pessoasCadastradas(){
        listaPessoasSalariosConsolidados = pessoaSalarioConsolidadoRepositorio.findAll();
    }
    public List<PessoaSalarioConsolidado> getListaPessoasSalariosConsolidados(){
        return listaPessoasSalariosConsolidados;
    }

    public void calcularERegistrarSalarios(){
        try {
            pessoaSalarioConsolidadoService.calcularERegistrarSalarios();
            pessoasCadastradas();
        } catch (Exception e){
            FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Valores já cadastrados."));
        }
    }
}
