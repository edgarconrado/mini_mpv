package net.tecgurus.mpv.service.compra;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.ICompraDao;
import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.model.entity.compra.Compra;
import net.tecgurus.mpv.model.mapper.compra.CompraMapper;

@Service
@RequiredArgsConstructor
public class CompraRecovery {
	private final ICompraDao compraDao;
	private final CompraMapper compraMapper;

	public List<CompraDto> listAll() {
		List<Compra> compras = this.compraDao.listAll();
		return compras.stream()
				.map(this.compraMapper::toDto)
				.toList();
	}

	public CompraDto getById(Long id) {
		Compra compra = this.compraDao.getById(id);
		return this.compraMapper.toDto(compra);
	}
}
