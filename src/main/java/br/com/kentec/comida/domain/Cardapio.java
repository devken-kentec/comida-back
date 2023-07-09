package br.com.kentec.comida.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cardapio")
@SuppressWarnings("serial")
public class Cardapio extends Identificador {
	
	@Column(name="tipo", nullable = true, length = 20)
	private String tipo;
	
	@Column(name="dia_semana", nullable = true, length = 20)
	private String diaSemana;
	
	@Column(name="observacao", nullable = true, length = 100) 
	private String observacao;
	
	public Cardapio() {
		
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Cardapio [tipo=" + tipo + ", diaSemana=" + diaSemana + ", observacao=" + observacao + "]";
	}
}
