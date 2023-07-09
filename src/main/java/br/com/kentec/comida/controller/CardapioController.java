package br.com.kentec.comida.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.comida.domain.Cardapio;
import br.com.kentec.comida.service.CardapioService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/comidaApp/api/cardapio")
public class CardapioController {
	
	@Autowired
	private CardapioService cs;
	
	@GetMapping("/mostrarUm/{id}")
	public ResponseEntity<Optional<Cardapio>> mostrarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(cs.mostarUmCardapio(id));
	}
	
	@GetMapping("/listarTodos")
	public ResponseEntity<Iterable<Cardapio>> listarCardapio(){
		return ResponseEntity.ok(cs.listarCardapio());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Cardapio salvarCardapio(@RequestBody Cardapio cardapio) {
		Cardapio cardapioRetorno = cs.salvarCardapio(cardapio);
		return cardapioRetorno;
	}

}
