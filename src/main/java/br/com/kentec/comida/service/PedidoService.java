package br.com.kentec.comida.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.comida.DTO.PedidoItemDTO;
import br.com.kentec.comida.domain.Pedido;
import br.com.kentec.comida.domain.PedidoItem;
import br.com.kentec.comida.domain.Usuario;
import br.com.kentec.comida.repository.PedidoItemRepository;
import br.com.kentec.comida.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pr;

	@Autowired
	private PedidoItemRepository pir;

	@Autowired
	private UsuarioService us;
	
	@Autowired
	private PedidoItemService pis;
	
	@Autowired
	private BebidaService bs;

	public Optional<Pedido> mostrarPedido(Long idPedido) {
		return pr.findById(idPedido);
	}

	public Pedido iniciarPedido(Long idUsuario) {
		Optional<Usuario> user = us.mostrarUm(idUsuario);
		Pedido pedido = new Pedido();
		if (user.isPresent()) {
			pedido.setUsuario(user.get());
			pedido = pr.save(pedido);
		}
		return pedido;
	}

	public void enviarPedido(PedidoItemDTO pedidoItemDTO) {
		Optional<Pedido> pedido = pr.findById(pedidoItemDTO.getIdPedido());
		if (pedido.isPresent()) {
			PedidoItem pedidoItem = new PedidoItem();
			pedidoItem.setQuantidade(pedidoItemDTO.getQuantidade());
			pedidoItem.setDescricao(pedidoItemDTO.getDescricao());
			pedidoItem.setItens(pedidoItemDTO.getItens());
			pedidoItem.setPrecoUnitario(pedidoItemDTO.getPrecoUnitario());
			pedidoItem.setPrecoTotal(pedidoItemDTO.getPrecoTotal());
			pedidoItem.setObservacao(pedidoItemDTO.getObservacao());
			pedidoItem.setStatus("Aberto");
			pedidoItem.setStatusMontagem("Montar");
			pedido.get().setDataPedido(LocalDate.now());
			pedido.get().setRetiradaProduto(pedidoItemDTO.getRetiradaProduto());
			pedido.get().setStatusPagamento("A receber");
			pedido.get().setTipoPagamento(pedidoItemDTO.getTipoPagamento());
			pedido.get().setStatus("Ativo");
			pedidoItem.setPedido(pedido.get());
			pr.save(pedido.get());
			pir.save(pedidoItem);
		}
	}

	public void cancelarPedido(Long id) {
		if (pir.findById(id).isPresent()) {
			pir.deleteById(id);
		}
	}
	
	public void somarValorPedido(Long idPedido) {
		BigDecimal somatorioPedido = pir.somarValorPedido(idPedido);
		BigDecimal somatorioBebida = bs.somarValorBebidaPedido(idPedido);
		Pedido pedido = mostrarPedido(idPedido).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pedido não encontrado"));
		pedido.setValorPedido(somatorioPedido);
		pedido.setValorBebida(somatorioBebida);
		pr.save(pedido);
		pis.modificarStatusPedidoItem(pedido);
	}
}
