package br.com.kentec.comida.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.comida.domain.Cardapio;
import br.com.kentec.comida.repository.CardapioRepository;

@Service
public class CardapioService {
	
	@Autowired
	private CardapioRepository cr;
	
	
	public Optional<Cardapio> mostarUmCardapio(Long id){
		return cr.findById(id);
	}
	
	public Iterable<Cardapio> listarCardapio(){
		return cr.findAll();
	}
	
	public Cardapio salvarCardapio(Cardapio cardapio) {
		Cardapio cardapioRetorno = cr.save(cardapio);
		return cardapioRetorno;
	}
	
	public Cardapio alterarCardapio(Cardapio cardapio) {
		Optional<Cardapio> card = mostarUmCardapio(cardapio.getId());
		Cardapio cardapioRetorno = new Cardapio();
		if(card.isPresent()) {
			cardapioRetorno = cr.save(cardapio);
		}
		return cardapioRetorno;
	}
}
