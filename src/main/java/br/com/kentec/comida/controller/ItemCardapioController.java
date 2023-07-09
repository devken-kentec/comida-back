package br.com.kentec.comida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.comida.DTO.ItemCardapioDTO;
import br.com.kentec.comida.service.ItemCardapioService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/comidaApp/api/itemCardapio")
public class ItemCardapioController {
	
	@Autowired
	private ItemCardapioService ics;
	
	@GetMapping("/listarCardapioDia/{idCardapio}")
	public ResponseEntity<List<ItemCardapioDTO>> listarCardapioDia(@PathVariable("idCardapio") Long idCardapio){
		return ResponseEntity.ok(ics.listarCardapioDia(idCardapio));
	}
	
	@GetMapping("/gerar/{idCardapio}/{idItem}")
	@ResponseStatus(HttpStatus.CREATED)
	public void gerarCardapio(@PathVariable("idCardapio") Long idCardapio, @PathVariable("idItem") Long idItem) {
		ics.gerarCardapio(idCardapio, idItem);
	}

	@GetMapping("/removerItemCardapio/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerItemCardapio(@PathVariable("id") Long id) {
		ics.removerItemCardapio(id);
	}
	
	@GetMapping("/listarCardapioDiaSemana/{diaSemana}")
	public ResponseEntity<Iterable<ItemCardapioDTO>> listarCardapioDiaSemana(@PathVariable("diaSemana") String diaSemana){
		return ResponseEntity.ok(ics.listarCardapioDiaSemana(diaSemana));
	}
}
