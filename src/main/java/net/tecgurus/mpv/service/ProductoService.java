package net.tecgurus.mpv.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IProdoctoDao;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.model.entity.producto.Producto;
import net.tecgurus.mpv.model.mapper.producto.ProductoMapper;

@Service
@RequiredArgsConstructor
public class ProductoService {
	private final IProdoctoDao productoDao;
	private final ProductoMapper productoMapper;
	
	public List<ProductoDto> listAll(){
		return this.productoDao.listAll().stream()
				.map(this.productoMapper::toDto)
				.toList();
	}
	
	public List<ProductoDto> listAll(int page, int limit){
		return this.productoDao.listAll(page - 1, limit).stream()
				.map(this.productoMapper::toDto)
				.toList();
	}
	
	public List<ProductoDto> search(String text){
		return this.productoDao.search(text).stream()
				.map(this.productoMapper::toDto)
				.toList();
	}
	
	public void updateAll(List<ProductoDto> productos) {
		List<Producto> entities = productos.stream()
				.map(this.productoMapper::toEntity)
				.toList();
		this.productoDao.updateAll(entities);
	}
	
	public boolean hasEnoughStock(Map<Long, Integer> productos) {
		List<Long> ids = productos.keySet().stream().toList();
		List<Producto> productsFromDb = this.productoDao.listIn(ids);
		
		for( Producto producto :productsFromDb) {
			int purchasedAmount = productos.get(producto.getIdProducto());
			boolean sold =  purchasedAmount > producto.getStock();
			if(sold) {
				return false;
			}
		}
		return true;
	}
	
}
