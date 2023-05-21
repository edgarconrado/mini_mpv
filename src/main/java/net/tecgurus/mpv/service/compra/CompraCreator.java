package net.tecgurus.mpv.service.compra;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.ICompraDao;
import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.model.entity.compra.Compra;
import net.tecgurus.mpv.model.mapper.compra.CompraMapper;

@Service
@RequiredArgsConstructor
public class CompraCreator {
	
	private final ICompraDao compraDao;
	private final CompraMapper compraMapper;
	
	public void create(CompraDto compra) {
		Compra entity = this.compraMapper.toEntity(compra);
		this.compraDao.create(entity);
		compra.setIdCompra(entity.getIdCompra());
	}
	
}
