package br.com.kentec.comida.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.comida.DTO.PedidoItemDTO;
import br.com.kentec.comida.domain.Pedido;
import br.com.kentec.comida.domain.PedidoItem;
import br.com.kentec.comida.repository.PedidoItemRepository;


@Service
public class PedidoItemService {
	
	@Autowired
	private PedidoItemRepository pir;
	
	public Optional<PedidoItem> findById(Long id){
		return pir.findById(id);
	}
	
	public Iterable<PedidoItemDTO> mostrarListaPedidosUsuarios(Long idUsuario){
		return pir.mostrarListaPedidosUsuarios(idUsuario).stream().map(PedidoItemDTO::new).collect(Collectors.toList());
	}
	
	public Iterable<PedidoItemDTO> mostrarListaPedidosMontar() {   
		return pir.mostrarListaPedidosMontar(LocalDate.now()).stream().map(PedidoItemDTO::new).collect(Collectors.toList());
	}
	
	public BigDecimal somarValorPedido(Long idPedido) {
		return pir.somarValorPedido(idPedido);
	}
	
	public void modificarStatusPedidoItem(Pedido pedido) {
		Iterable<PedidoItem> pedidoItem = pir.findByPedido(pedido);
		pedidoItem.forEach(pi -> {
			pi.setStatus("Fechado");
			pir.save(pi);
		});
	}
}
