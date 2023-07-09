package br.com.kentec.comida.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="valores")
@SuppressWarnings("serial")
public class Valores extends Identificador {
	
	@Column(name="descricao", nullable = true, length = 60)
	private String descricao;
	
	@Column(name="valor", nullable = true, precision = 10, scale = 2)
	private BigDecimal valor;
	
	public Valores() {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Valores [descricao=" + descricao + ", valor=" + valor + "]";
	}
}
