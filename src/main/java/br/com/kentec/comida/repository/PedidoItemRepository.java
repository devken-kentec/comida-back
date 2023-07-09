package br.com.kentec.comida.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.comida.domain.Pedido;
import br.com.kentec.comida.domain.PedidoItem;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
	
	@Query("SELECT pi FROM PedidoItem pi WHERE pi.pedido.usuario.id = :id ORDER BY pi.pedido.id DESC ")
	List<PedidoItem> mostrarListaPedidosUsuarios(@Param("id") Long idUsuario);
	
	@Query("SELECT SUM(pi.precoTotal) FROM PedidoItem pi WHERE pi.pedido.id = :idPedido ")
	BigDecimal somarValorPedido(@Param("idPedido") Long idPedido);
	
	Iterable<PedidoItem> findByPedido(Pedido pedido);
	
	@Query("SELECT pi FROM PedidoItem pi WHERE pi.pedido.dataPedido = :dataPedido "
													 + "AND pi.status = 'Fechado' "
													 + "AND pi.statusMontagem = 'Montar' ")
	List<PedidoItem> mostrarListaPedidosMontar(@Param("dataPedido") LocalDate dataPedido);
}
