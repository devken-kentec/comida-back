package br.com.kentec.comida.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.comida.DTO.BebidaDTO;
import br.com.kentec.comida.service.BebidaService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/comidaApp/api/bebidas")
public class BebidaController {
	
	@Autowired
	private BebidaService bs;
	
	@GetMapping("/listarPorPedido/{pedido}")
	public ResponseEntity<Iterable<BebidaDTO>> listarBebidas(@PathVariable("pedido") Long pedido){
		return ResponseEntity.ok(bs.findByPedido(pedido));
	}
	
	@GetMapping("/somarValorPorPedido/{pedido}")
	public BigDecimal somarValorBebidaPedido(@PathVariable("pedido") Long pedido){
		 return bs.somarValorBebidaPedido(pedido);
	}
	
	@DeleteMapping("/excluirBebida/{idBebida}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirBebida(@PathVariable("idBebida") Long idBebida) {
		bs.excluirBebida(idBebida);
	}
	
	
}	
