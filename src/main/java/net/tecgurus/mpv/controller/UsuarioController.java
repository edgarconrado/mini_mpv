package net.tecgurus.mpv.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.service.UsuarioService;


@RestController
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	//http://localhost:8080/usuario
	@PostMapping("/usuario")
	public ResponseEntity<UsuarioDto> signup(@RequestBody @Valid UsuarioDto usuario){	
		
		UsuarioDto currentUser = this.usuarioService.getByEmail(usuario.getEmail());
		
		if(currentUser != null) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, 
					"The email is currently on use"
				);
		}	
		
		this.usuarioService.signup(usuario);
		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}
	
}
