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

import br.com.kentec.comida.domain.Valores;
import br.com.kentec.comida.service.ValoresService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/comidaApp/api/valores")
public class ValoresController {
	
	@Autowired
	private ValoresService vs;
	
	@GetMapping("/listarUm/{id}")
	public ResponseEntity<Optional<Valores>> listarUmValor(@PathVariable("id") Long id){
		return ResponseEntity.ok(vs.listarUmValor(id));
	}
	
	@GetMapping("/listarTodosAtivo")
	public ResponseEntity<Iterable<Valores>> listarValoresAtivo(){
		return ResponseEntity.ok(vs.listarValoresAtivo());
	}
	
	@GetMapping("/listarTodos")
	public ResponseEntity<Iterable<Valores>> listarValores(){
		return ResponseEntity.ok(vs.listarValores());
	} 
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarValores(@RequestBody Valores valor) {
		vs.salvarValores(valor);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarValores(@RequestBody Valores valor) {
		vs.alterarValores(valor);
	}
}
	