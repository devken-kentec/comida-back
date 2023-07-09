package br.com.kentec.comida.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.comida.DTO.ItemCardapioDTO;
import br.com.kentec.comida.domain.Cardapio;
import br.com.kentec.comida.domain.Item;
import br.com.kentec.comida.domain.ItemCardapio;
import br.com.kentec.comida.repository.ItemCardapioRepository;

@Service
public class ItemCardapioService {
	
	@Autowired
	private CardapioService cs;
	
	@Autowired
	private ItemService is;
	
	@Autowired
	private ItemCardapioRepository icr;
	
	public List<ItemCardapioDTO> listarCardapioDia(Long id) {
		return icr.listarCardapioDia(id).stream().map(ItemCardapioDTO::new).collect(Collectors.toList());
	}
	
	public void gerarCardapio(Long idCardapio, Long idItem) {
		Optional<Cardapio> cardapio = cs.mostarUmCardapio(idCardapio);
		if(cardapio.isPresent()) {
			Optional<Item> item = is.listarUmItem(idItem);
			if(item.isPresent()) {
				ItemCardapio itemCardapio = new ItemCardapio();
				itemCardapio.setStatus("Ativo");
				itemCardapio.setCardapio(cardapio.get());
				itemCardapio.setItem(item.get());
				icr.save(itemCardapio);
			}
		}	
	}
	
	public void removerItemCardapio(Long id) {
		Optional<ItemCardapio> itemRemover = icr.findById(id);
		if(itemRemover.isPresent()) {
			icr.delete(itemRemover.get());
		}
	}
	
	public List<ItemCardapioDTO> listarCardapioDiaSemana(String diaSemana){
		return icr.listarCardapioDiaSemana(diaSemana).stream().map(ItemCardapioDTO::new).collect(Collectors.toList());
	}
	
}
