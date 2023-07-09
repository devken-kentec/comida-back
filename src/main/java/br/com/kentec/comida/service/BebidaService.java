package br.com.kentec.comida.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.comida.DTO.BebidaDTO;

import br.com.kentec.comida.domain.Bebidas;
import br.com.kentec.comida.domain.Item;
import br.com.kentec.comida.domain.Pedido;
import br.com.kentec.comida.repository.BebidaRepository;
import br.com.kentec.comida.repository.ItemRepository;
import br.com.kentec.comida.repository.PedidoRepository;

@Service
public class BebidaService {
	
	@Autowired
	private BebidaRepository br;
	
	@Autowired
	private PedidoRepository pr;
	
	@Autowired
	private ItemRepository ir;
	
	public Iterable<BebidaDTO> findByPedido(Long pedido) {
		return br.findByPedido(pedido).stream().map(BebidaDTO::new).collect(Collectors.toList());
	} 
	
	public BigDecimal somarValorBebidaPedido(Long pedido) {
		return br.somarValorBebidaPedido(pedido);
	}
	
	public void gravarPedidoBebida(Long pedido, Long idBebida, Integer quantidade) {
		
		Optional<Pedido> ped = pr.findById(pedido);
		Optional<Item> item = ir.findById(idBebida);
		if(ped.isPresent()) {
			if(item.isPresent()) {
				Bebidas beb = new Bebidas();
				beb.setDescricao(item.get().getDescricao());
				beb.setQuantidade(quantidade);
				
				BigDecimal convert = BigDecimal.valueOf(quantidade);
				BigDecimal valorTotal = item.get().getValorUnitario().multiply(convert);
				
				beb.setTotal(valorTotal);
				beb.setPedido(ped.get());
				br.save(beb);
			}
		}
	}
	
	public void excluirBebida(Long idBebida) {
		Optional<Bebidas> beb = br.findById(idBebida);
		if(beb.isPresent()) {
			br.delete(beb.get());
		}
 	}
}
