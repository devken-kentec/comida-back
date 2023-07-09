package br.com.kentec.comida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.kentec.comida.domain.Item;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long> {
	
	@Query("SELECT i FROM Item i WHERE i.status = 'Ativo' ")
	Iterable<Item> listarItemAtivo();
	
	@Query("SELECT i FROM Item i WHERE i.tipo = 'Bebida' AND i.status = 'Ativo' ")
	Iterable<Item> findByBebidasAtiva();
}
