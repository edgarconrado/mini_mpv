package net.tecgurus.mpv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.service.compra.CompraRecovery;
import net.tecgurus.mpv.service.compra.CompraService;

@RestController
@RequiredArgsConstructor
public class CompraController {
	
	private final CompraService compraService;
	private final CompraRecovery compraRecovery;
	
	@PostMapping("/compra")
	public ResponseEntity<CompraDto> buy(@RequestBody CompraDto compra){
		boolean hasAvailableStock = this.compraService.validateStockFromCompra(compra);
		if(!hasAvailableStock) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No available stock");
		}
		
		compra = this.compraService.buy(compra);
		return ResponseEntity.ok(compra);
	}
	
	@GetMapping("/compra")
	public ResponseEntity<List<CompraDto>> listAll(){
		return ResponseEntity.ok(this.compraRecovery.listAll());
	}
	
}
