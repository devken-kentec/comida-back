package br.com.kentec.comida.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bebidas")
@SuppressWarnings("serial")
public class Bebidas extends Identificador {
	
	@Column(name="quantidade", nullable = true, length = 5)
	private Integer quantidade;
	
	@Column(name="descricao", nullable = true, length = 30)
	private String descricao; 
	
	@Column(name="total", nullable = true, precision = 10, scale = 2)
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name="pedido_id", nullable = false)
	private Pedido pedido = new Pedido();
	
	public Bebidas() {
		
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Bebidas [quantidade=" + quantidade + ", descricao=" + descricao + ", total=" + total + ", pedido="
				+ pedido + "]";
	}
	
}
