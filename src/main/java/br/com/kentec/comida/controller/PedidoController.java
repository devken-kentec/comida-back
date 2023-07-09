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

import br.com.kentec.comida.DTO.PedidoItemDTO;
import br.com.kentec.comida.domain.Pedido;
import br.com.kentec.comida.domain.PedidoItem;
import br.com.kentec.comida.service.PedidoItemService;
import br.com.kentec.comida.service.PedidoService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/comidaApp/api/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService ps;
	
	@Autowired
	private PedidoItemService pis;
	
	@GetMapping("/mostrarPedido/{idPedido}")
	public ResponseEntity<Optional<Pedido>> mostrarPedido(@PathVariable("idPedido") Long idPedido){
		return ResponseEntity.ok(ps.mostrarPedido(idPedido));
	}
	
	@GetMapping("/mostrarListaPedidosUsuarios/{idUsuario}")
	public ResponseEntity<Iterable<PedidoItemDTO>> mostrarListaPedidosUsuarios(@PathVariable("idUsuario") Long idUsuario){
		return ResponseEntity.ok(pis.mostrarListaPedidosUsuarios(idUsuario));
	}
	
	@GetMapping("/mostrarListaPedidosMontar")
	public ResponseEntity<Iterable<PedidoItemDTO>> mostrarListaPedidosMontar(){
		return ResponseEntity.ok(pis.mostrarListaPedidosMontar());
	}
	
	@GetMapping("/iniciarPedido/{idUsuario}")
	public ResponseEntity<Pedido> iniciarPedido(@PathVariable("idUsuario") Long idUsuario) {
		return ResponseEntity.ok(ps.iniciarPedido(idUsuario)) ;
	}
	
	@PostMapping("/enviar")
	@ResponseStatus(HttpStatus.CREATED)
	public void enviarPedido(@RequestBody PedidoItemDTO pedidoItemDTO) {
		ps.enviarPedido(pedidoItemDTO);
	}
	
	@GetMapping("/testePedido/{id}")
	public Optional<PedidoItem> findById(@PathVariable("id") Long id){
		return pis.findById(id);
	}
	
	@GetMapping("/cancelarPedido/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cancelarPedido(@PathVariable("id") Long id) {
		ps.cancelarPedido(id);
	}
	
	@GetMapping("/somarValorPedido/{idPedido}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void somarValorPedido(@PathVariable("idPedido") Long idPedido) {
		ps.somarValorPedido(idPedido);
	}
}
