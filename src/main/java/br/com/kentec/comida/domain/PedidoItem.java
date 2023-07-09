package br.com.kentec.comida.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido_item")
@SuppressWarnings("serial")
public class PedidoItem extends Identificador {
	
	@Column(name="quantidade", nullable = true, length = 3)
	private Integer quantidade;
	
	@Column(name="descricao", nullable = true, length = 30)
	private String descricao;
	
	@Column(name="itens", nullable = true, length = 1000)
	private String itens;
	
	@Column(name="preco_unitario", nullable = true, precision = 10, scale = 2)
	private BigDecimal precoUnitario;
	
	@Column(name="preco_total", nullable = true, precision = 10, scale = 2)
	private BigDecimal precoTotal;
	
	@Column(name="observacao", nullable = true, length = 500)
	private String observacao;
	
	@Column(name="status_montagem", nullable = true, length = 30)
	private String statusMontagem;
	
	@ManyToOne
	@JoinColumn(name="pedido_id", nullable = false)
	private Pedido pedido = new Pedido();
	
	public PedidoItem() {
		
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

	public String getItens() {
		return itens;
	}

	public void setItens(String itens) {
		this.itens = itens;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public String getStatusMontagem() {
		return statusMontagem;
	}

	public void setStatusMontagem(String statusMontagem) {
		this.statusMontagem = statusMontagem;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "PedidoItem [quantidade=" + quantidade + ", descricao=" + descricao + ", itens=" + itens
				+ ", precoUnitario=" + precoUnitario + ", precoTotal=" + precoTotal + ", observacao=" + observacao
				+ ", statusMontagem=" + statusMontagem + ", pedido=" + pedido + "]";
	}
}
