package net.tecgurus.mpv.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.model.dto.ClienteDto;
import net.tecgurus.mpv.service.ClienteService;

@RestController
@RequiredArgsConstructor
public class ClienteController {
	private final ClienteService clienteService;
	
	@GetMapping("/cliente")
	public ResponseEntity<List<ClienteDto>> listAll(){
		List<ClienteDto> clientes = this.clienteService.listAll();
		return ResponseEntity.ok(clientes);
	}
}
