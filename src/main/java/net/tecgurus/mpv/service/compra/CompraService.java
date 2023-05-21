package net.tecgurus.mpv.service.compra;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.model.dto.compra.CompraProductoDto;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.service.ProductoService;

@Service
@RequiredArgsConstructor
public class CompraService {
	private final CompraCreator compraCreator;
	private final CompraRecovery compraRecovery;
	private final CompraPricesCalculator compraPricesCalculator;
	private final ProductoService productoService;
	
	public CompraDto buy(CompraDto compra) {
		
		//set date to buy
		compra.setFecha(LocalDate.now());
		compra.setTotal(0.0);
		
		//Save the current data
		this.compraCreator.create(compra);
		compra = this.compraRecovery.getById(compra.getIdCompra());
		
		//calculate total by product
		this.compraPricesCalculator.calcualteTotalByProduct(compra);
		
		//calculate total buy
		double total = this.compraPricesCalculator.calculateTotalOfCompra(compra);
		compra.setTotal(total);
		
		//update product stock
		List<ProductoDto> updatedProducts = this.compraPricesCalculator.updateProductoStock(compra);
		this.productoService.updateAll(updatedProducts);
		
		//update entity compra
		this.compraCreator.create(compra);
		
		//get entity and return
		return this.compraRecovery.getById(compra.getIdCompra());

	}
	
	public boolean validateStockFromCompra(CompraDto compra) {	
		Map<Long, Integer> productos = compra.getProductos().stream()
			.collect(Collectors.toMap(
				cp -> cp.getProducto().getIdProducto(),
					CompraProductoDto::getCantidad)
			);
		return this.productoService.hasEnoughStock(productos);
	}
	
}
