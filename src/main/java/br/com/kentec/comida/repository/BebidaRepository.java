package br.com.kentec.comida.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.comida.domain.Bebidas;


@Repository
public interface BebidaRepository extends JpaRepository<Bebidas, Long> {

	@Query("SELECT b FROM Bebidas b "
			+ " JOIN b.pedido p WHERE p.id = :pedido ")
	List<Bebidas> findByPedido(@Param("pedido") Long pedido); 
	
	
	@Query(nativeQuery=true, value="SELECT SUM(total) FROM bebidas as b "
						+ "JOIN pedido AS p "
						+ "ON p.id = b.pedido_id "
						+ "WHERE pedido_id = :pedido")
	BigDecimal somarValorBebidaPedido(@Param("pedido") Long pedido);
}
