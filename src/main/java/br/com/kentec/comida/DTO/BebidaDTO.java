package br.com.kentec.comida.DTO;

import java.math.BigDecimal;

import br.com.kentec.comida.domain.Bebidas;

public class BebidaDTO {
	
	private Long id;
	private String descricao;
	private Integer quantidade;
	private BigDecimal total;
	
	
	public BebidaDTO() {
		
	}
	
	public BebidaDTO(Bebidas beb) {
		this.id = beb.getId();
		this.descricao = beb.getDescricao();
		this.quantidade = beb.getQuantidade();
		this.total = beb.getTotal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "BebidaDTO [id=" + id + ", descricao=" + descricao + ", quantidade=" + quantidade + ", total=" + total
				+ "]";
	}
}
