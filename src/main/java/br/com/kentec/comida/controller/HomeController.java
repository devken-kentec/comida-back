package br.com.kentec.comida.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.comida.domain.Item;
import br.com.kentec.comida.domain.Usuario;
import br.com.kentec.comida.service.ItemService;
import br.com.kentec.comida.service.UsuarioService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/comidaApp/api/home")
public class HomeController {
	
	@Autowired
	private ItemService is;
	
	@Autowired
	private UsuarioService us;
	
	@PostMapping("/trazerUsuario")
	public ResponseEntity<Optional<Usuario>> trazerUsuario(@RequestBody String senha){
		return ResponseEntity.ok(us.buscarPorSenha(senha));
	}
	
	@GetMapping("/listarTodos")
	public ResponseEntity<Iterable<Item>> listarItens(){
		return ResponseEntity.ok(is.listarItens());
	}
	
	@PostMapping("/salvarUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public void gravarUsuario(@RequestBody Usuario usuario) {	
		us.salvarUsuario(usuario);
	}
}
