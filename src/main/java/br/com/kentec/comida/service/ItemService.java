package br.com.kentec.comida.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.comida.domain.Item;
import br.com.kentec.comida.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository ir;
	
	public Optional<Item> listarUmItem(Long id){
		return ir.findById(id);
	}
	
	public Iterable<Item> listarItens(){
		return ir.findAll();
	}
	
	public Iterable<Item> listarItemAtivo(){
		return ir.listarItemAtivo();
	}
	
	public Iterable<Item> listarBebidas(){
		return ir.findByBebidasAtiva();
	}
	
	public void salvarItem(Item item) {
		ir.save(item);
	}
	
	public void alterarItem(Item item) {
		Optional<Item> itens = listarUmItem(item.getId());
		if(itens.isPresent()) {
			ir.save(item);
		}
	}
}
