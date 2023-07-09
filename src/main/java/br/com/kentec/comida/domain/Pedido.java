package br.com.kentec.comida.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
@SuppressWarnings("serial")
public class Pedido extends Identificador {
	
	@Column(name="tipo_pagamento", nullable = true, length = 20)
	private String tipoPagamento;
	
	@Column(name="status_pagamento", nullable = true, length = 20)
	private String statusPagamento;
	
	@Column(name="retirada_produto", nullable = true, length = 20)
	private String retiradaProduto;
	
	@Column(name="valor_pedido", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorPedido;
	
	@Column(name="valor_bebida", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorBebida;
	
	@Column(name="taxa_entraga", nullable = true, precision = 10, scale = 2)
	private BigDecimal taxaEntraga;
	
	@Column(name="descontos", nullable = true, precision = 10, scale = 2)
	private BigDecimal descontos;
	
	@Column(name="data_pedido", nullable = true, length = 25)
	private LocalDate dataPedido;
	
	@Column(name="data_entrega", nullable = true, length = 25)
	private LocalDateTime dataEntrega;
	
	@Column(name="foto", nullable = true)
	@Lob
	private byte[] foto;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario = new Usuario();
	
	public Pedido() {
		
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getRetiradaProduto() {
		return retiradaProduto;
	}

	public void setRetiradaProduto(String retiradaProduto) {
		this.retiradaProduto = retiradaProduto;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	public BigDecimal getValorBebida() {
		return valorBebida;
	}

	public void setValorBebida(BigDecimal valorBebida) {
		this.valorBebida = valorBebida;
	}

	public BigDecimal getTaxaEntraga() {
		return taxaEntraga;
	}

	public void setTaxaEntraga(BigDecimal taxaEntraga) {
		this.taxaEntraga = taxaEntraga;
	}

	public BigDecimal getDescontos() {
		return descontos;
	}

	public void setDescontos(BigDecimal descontos) {
		this.descontos = descontos;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Pedido [tipoPagamento=" + tipoPagamento + ", statusPagamento=" + statusPagamento + ", retiradaProduto="
				+ retiradaProduto + ", valorPedido=" + valorPedido + ", valorBebida=" + valorBebida + ", taxaEntraga="
				+ taxaEntraga + ", descontos=" + descontos + ", dataPedido=" + dataPedido + ", dataEntrega="
				+ dataEntrega + ", foto=" + Arrays.toString(foto) + ", usuario=" + usuario + "]";
	}
}
