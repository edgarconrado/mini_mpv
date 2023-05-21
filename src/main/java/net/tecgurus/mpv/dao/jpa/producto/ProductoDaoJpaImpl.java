package net.tecgurus.mpv.dao.jpa.producto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IProdoctoDao;
import net.tecgurus.mpv.model.entity.producto.Producto;

@Repository
@RequiredArgsConstructor
public class ProductoDaoJpaImpl implements IProdoctoDao{

	private final ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listAll() {
		return this.productoRepository.findByStockGreaterThan(0);
	}
	
	@Override
	public List<Producto> listAll(int page, int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		Page<Producto> products = 
				this.productoRepository.findByStockGreaterThan(0, pageable);
		return products.getContent();
	}

	@Override
	public List<Producto> search(String search) {
		return this.productoRepository.search(search);
	}

	@Override
	public void updateAll(List<Producto> productos) {
		this.productoRepository.saveAllAndFlush(productos);
	}

	@Override
	public List<Producto> listIn(List<Long> ids) {
		return this.productoRepository.findAllById(ids);
	}
}
