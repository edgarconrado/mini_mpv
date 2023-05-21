package net.tecgurus.mpv.model.mapper.compra;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.model.entity.compra.Compra;
import net.tecgurus.mpv.model.mapper.ClienteMapper;
import net.tecgurus.mpv.model.mapper.UsuarioMapper;

@Mapper(
	componentModel = "spring",
	uses = {ClienteMapper.class, UsuarioMapper.class }
)
public interface CompraMapper {
	@Mapping(target = "usuario", qualifiedByName = "resume" )
	CompraDto toDto(Compra entity);
	Compra toEntity(CompraDto dto);
}
