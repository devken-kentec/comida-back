package br.com.kentec.comida.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.comida.domain.Usuario;
import br.com.kentec.comida.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository ur;
	
	public Optional<Usuario> mostrarUm(Long id) {
		return ur.findById(id);
	}
	
	public Optional<Usuario> buscarPorSenha(String senha){
		Optional<Usuario> usuario = ur.findBySenha(senha);
		return Optional.ofNullable(usuario.orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não Encontrado!!"))); 
	}
	
	public void salvarUsuario(Usuario usuario) {
		try {
			usuario.setRole("Cliente");
			usuario.setStatus("Ativo");
			ur.save(usuario);
		} catch (ResponseStatusException e) {
			System.out.println("Este -> " + e);
		}
	}
	
	public void gerarSenha() {
		UUID uuId = UUID.randomUUID();
		System.out.println(uuId);
	}
}
