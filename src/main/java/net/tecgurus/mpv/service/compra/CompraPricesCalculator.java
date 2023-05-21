package net.tecgurus.mpv.service.compra;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.model.dto.compra.CompraProductoDto;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;

@Service
public class CompraPricesCalculator {
	
	public void calcualteTotalByProduct(CompraDto compra) {
		
		Consumer<CompraProductoDto> calcualteTotal = compraProducto -> {
			int contidad = compraProducto.getCantidad();
			double precio = compraProducto.getProducto().getPrecio();
			double total = contidad * precio;
			compraProducto.setCosto(total);
		};
		
		compra.getProductos().forEach(calcualteTotal);
	}
	
	public Double calculateTotalOfCompra(CompraDto compra) {
		return compra.getProductos().stream()
		.map(CompraProductoDto::getCosto)
		.reduce(Double::sum).orElse(0.0);
	}
	
	
	public List<ProductoDto> updateProductoStock(CompraDto compra){
		return compra.getProductos().stream()
				.map( compraProducto -> {
					ProductoDto producto = compraProducto.getProducto();
					int currentStock = producto.getStock();
					int purchasedAmount = compraProducto.getCantidad();
					producto.setStock(currentStock - purchasedAmount);
					return producto;
				})
				.toList();
	}
	
}
