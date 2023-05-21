package net.tecgurus.mpv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.model.dto.producto.CategoriaDto;
import net.tecgurus.mpv.service.CategoriaService;

@RestController
@RequiredArgsConstructor
public class CategoriaController {
	
	private final CategoriaService categoriaService;
	
	@PostMapping("/categoria")
	public ResponseEntity<CategoriaDto> create(@RequestBody CategoriaDto categoria){
		this.categoriaService.create(categoria);
		return new ResponseEntity<>(categoria, HttpStatus.CREATED);
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<CategoriaDto>> listAll(){
		List<CategoriaDto> response = this.categoriaService.listAll();
		return ResponseEntity.ok(response);
	}
	
}
