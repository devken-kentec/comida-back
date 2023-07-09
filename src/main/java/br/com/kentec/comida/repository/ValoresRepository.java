package br.com.kentec.comida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.kentec.comida.domain.Valores;

@Repository
public interface ValoresRepository extends JpaRepository<Valores, Long> {
	
	@Query("SELECT v FROM Valores v WHERE v.status = 'Ativo' ")
	Iterable<Valores> listarTodosAtivos();
}
