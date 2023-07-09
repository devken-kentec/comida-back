package br.com.kentec.comida.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_cardapio")
@SuppressWarnings("serial")
public class ItemCardapio extends Identificador {
	
	@Column(name="posicao", nullable = true, length = 11)
	private Integer posicao;
	
	@ManyToOne
	@JoinColumn(name="id_cardapio", nullable = true)
	private Cardapio cardapio = new Cardapio();
	
	@ManyToOne
	@JoinColumn(name="id_item", nullable = true)
	private Item item = new Item();
	
	public ItemCardapio() {
		
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemCardapio [posicao=" + posicao + ", cardapio=" + cardapio + ", item=" + item + "]";
	}
}
