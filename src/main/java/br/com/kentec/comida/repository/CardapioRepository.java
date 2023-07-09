package br.com.kentec.comida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.comida.domain.Cardapio;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

}
