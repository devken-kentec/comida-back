package br.com.kentec.comida.DTO;

import br.com.kentec.comida.domain.ItemCardapio;

public class ItemCardapioDTO {
	
	private Long id;
	private Long idCardapio;
	private Long idItem;
	private String itemDescricao;
	private String diaCardapio;
	
	public ItemCardapioDTO() {
		
	}
		
	public ItemCardapioDTO(ItemCardapio itemCardapio) {
		this.id = itemCardapio.getId();
		this.idCardapio = itemCardapio.getCardapio().getId();
		this.idItem = itemCardapio.getItem().getId();
		this.itemDescricao = itemCardapio.getItem().getDescricao();
		this.diaCardapio = itemCardapio.getCardapio().getDiaSemana();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Long idCardapio) {
		this.idCardapio = idCardapio;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getItemDescricao() {
		return itemDescricao;
	}

	public void setItemDescricao(String itemDescricao) {
		this.itemDescricao = itemDescricao;
	}

	public String getDiaCardapio() {
		return diaCardapio;
	}

	public void setDiaCardapio(String diaCardapio) {
		this.diaCardapio = diaCardapio;
	} 

	@Override
	public String toString() {
		return "ItemCardapioDTO [id=" + id + ", idCardapio=" + idCardapio + ", idItem=" + idItem + ", itemDescricao="
				+ itemDescricao + ", diaCardapio=" + diaCardapio + "]";
	}
}
