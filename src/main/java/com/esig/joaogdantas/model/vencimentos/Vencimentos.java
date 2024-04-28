package com.esig.joaogdantas.model.vencimentos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "vencimentos")
@Table(name = "vencimentos")
public class Vencimentos {
	@Column(name = "id")
    private Long id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "tipo")
    private TipoVencimento tipo;
    
	public Vencimentos() {
	}

	public Vencimentos(Long id, String descricao, Double valor, TipoVencimento tipo) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.tipo = tipo;
	}
	
    public Long getId() {
		return id;
	}
    
    public String getDescricao() {
		return descricao;
	}
    
    public Double getValor() {
		return valor;
	}
    
    public TipoVencimento getTipo() {
		return tipo;
	}
    
    public void setId(Long id) {
		this.id = id;
	}
    
    public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    public void setValor(Double valor) {
		this.valor = valor;
	}
    
    public void setTipo(TipoVencimento tipo) {
		this.tipo = tipo;
	}
}
