package br.com.kentec.comida.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.comida.domain.ItemCardapio;

@Repository
public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long>{
	
	@Query("SELECT ic FROM ItemCardapio ic WHERE ic.cardapio.id = :id ")
	List<ItemCardapio> listarCardapioDia(@Param("id") Long id);
	
	@Query("SELECT ic FROM ItemCardapio ic WHERE ic.cardapio.diaSemana = :diaSemana AND ic.cardapio.status = 'Ativo' ")
	List<ItemCardapio> listarCardapioDiaSemana(@Param("diaSemana") String diaSemana);
}
