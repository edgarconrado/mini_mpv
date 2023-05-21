package net.tecgurus.mpv.model.mapper.producto;

import org.mapstruct.Mapper;

import net.tecgurus.mpv.model.dto.producto.CategoriaDto;
import net.tecgurus.mpv.model.entity.producto.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
	CategoriaDto toDto(Categoria entity);
	Categoria toEntity(CategoriaDto dto);
}
