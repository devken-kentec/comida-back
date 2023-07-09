package br.com.kentec.comida.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="item")
@SuppressWarnings("serial")
public class Item extends Identificador {
	
	@Column(name="descricao", nullable = true, length = 120)
	private String descricao;
	
	@Column(name="unidade_medida", nullable = true, length = 15)
	private String unidadeMedida;
	
	@Column(name="tipo", nullable = true, length = 20)
	private String tipo;
	
	@Column(name="tamanho", nullable = true, length = 15)
	private String tamanho;
	
	@Column(name="valor_unitario", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorUnitario;
	
	@Column(name="foto", nullable = true)
	@Lob
	private byte[] foto;
	
	public Item() {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Item [descricao=" + descricao + ", unidadeMedida=" + unidadeMedida + ", tipo=" + tipo + ", tamanho="
				+ tamanho + ", valorUnitario=" + valorUnitario + ", foto=" + Arrays.toString(foto) + "]";
	}
}