package net.tecgurus.mpv.model.mapper.producto;

import org.mapstruct.Mapper;

import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.model.entity.producto.Producto;

@Mapper(
	componentModel = "spring", 
	uses = {CategoriaMapper.class}
)
public interface ProductoMapper {
	ProductoDto toDto(Producto entity);
	Producto toEntity(ProductoDto dto);
}
