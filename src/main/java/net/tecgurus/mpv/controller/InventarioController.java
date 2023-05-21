package net.tecgurus.mpv.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.model.dto.InventarioDto;
import net.tecgurus.mpv.service.InventarioService;

@RestController
@RequiredArgsConstructor
public class InventarioController {
	private final InventarioService inventarioService;
	
	@GetMapping("/inventario")
	public ResponseEntity<List<InventarioDto>> generateInventory() {
		List<InventarioDto> inventario = this.inventarioService.generateInventory();
		return ResponseEntity.ok(inventario);
	}
	
}
