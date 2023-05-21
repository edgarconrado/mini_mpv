package net.tecgurus.mpv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.ICategoriaDao;
import net.tecgurus.mpv.model.dto.producto.CategoriaDto;
import net.tecgurus.mpv.model.entity.producto.Categoria;
import net.tecgurus.mpv.model.mapper.producto.CategoriaMapper;

@Service
@RequiredArgsConstructor
public class CategoriaService {
	
	private final ICategoriaDao categoriaDao;
	private final CategoriaMapper categoriaMapper;
	
	public void create(CategoriaDto categoria) {
		Categoria entity = this.categoriaMapper.toEntity(categoria);
		this.categoriaDao.create(entity);
		categoria.setIdCategoria(entity.getIdCategoria());
	}
	
	public List<CategoriaDto> listAll(){
		return this.categoriaDao.listAll().stream()
			.map(this.categoriaMapper::toDto)
			.toList();
	}
	
}
