package br.com.kentec.comida.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.comida.domain.Item;
import br.com.kentec.comida.service.BebidaService;
import br.com.kentec.comida.service.ItemService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/comidaApp/api/item")
public class ItemController {
	
	@Autowired
	private ItemService is;
	
	@Autowired
	private BebidaService bs;
	
	@GetMapping("/listarUm/{id}")
	public Optional<Item> listarUmItem(@PathVariable("id") Long id){
		return is.listarUmItem(id);
	}
	
	@GetMapping("/listarTodos")
	public ResponseEntity<Iterable<Item>> listarItens(){
		return ResponseEntity.ok(is.listarItens());
	}
	
	@GetMapping("/listarBebidas")
	public ResponseEntity<Iterable<Item>> listarBebidas(){
		return ResponseEntity.ok(is.listarBebidas());
	}
	
	@GetMapping("/incluirBebidaPedido/{pedido}/{idBebida}/{quantidade}")
	@ResponseStatus(HttpStatus.CREATED)
	public void incluirBebida(@PathVariable("pedido") Long pedido, 
									@PathVariable("idBebida") Long idBebida,
									@PathVariable("quantidade") Integer quantidade) {
		
		bs.gravarPedidoBebida(pedido, idBebida, quantidade);
	}
	
	@GetMapping("/listarItemAtivo")
	public ResponseEntity<Iterable<Item>> listarItemAtivo(){
		return ResponseEntity.ok(is.listarItemAtivo());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarItem(@RequestBody Item item) {
		is.salvarItem(item);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarItem(@RequestBody Item item) {
		is.alterarItem(item);
	}
	
}
