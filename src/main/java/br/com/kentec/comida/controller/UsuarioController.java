package br.com.kentec.comida.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.comida.domain.Usuario;
import br.com.kentec.comida.service.UsuarioService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/comidaApp/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService us;
	
	@GetMapping("/mostrarUm/{id}")
	public ResponseEntity<Optional<Usuario>> mostrarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(us.mostrarUm(id)) ;
	}

}
