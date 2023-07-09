package br.com.kentec.comida.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.comida.domain.Valores;
import br.com.kentec.comida.repository.ValoresRepository;

@Service
public class ValoresService {
	
	@Autowired
	private ValoresRepository vr;
	
	public Optional<Valores> listarUmValor(Long id){
		return vr.findById(id);
	}
	
	public Iterable<Valores> listarValoresAtivo(){
		return vr.listarTodosAtivos();
	}
	
	public Iterable<Valores> listarValores(){
		return vr.findAll();
	}
	
	public void salvarValores(Valores valor) {
		vr.save(valor);
	}
	
	public void alterarValores(Valores valor) {
		if(listarUmValor(valor.getId()).isPresent()) {
			vr.save(valor);
		}
	}
}
