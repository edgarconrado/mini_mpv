package net.tecgurus.mpv.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.service.ProductoService;

@RestController
@RequiredArgsConstructor
public class ProductoController {
	
	private final ProductoService productoService;
	
	@GetMapping("/producto")
	public ResponseEntity<List<ProductoDto>> listAll(){
		List<ProductoDto> productos = this.productoService.listAll();
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping("/producto/page")
	public ResponseEntity<List<ProductoDto>> listAll(
			@RequestParam("page") Integer page, 
			@RequestParam("limit") Integer limit
	){
		List<ProductoDto> productos = this.productoService.listAll(page, limit);
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping("/producto/busqueda/{param}")
	public ResponseEntity<List<ProductoDto>> search(@PathVariable String param){
		List<ProductoDto> productos = this.productoService.search(param);
		return ResponseEntity.ok(productos);
	}
	
}
