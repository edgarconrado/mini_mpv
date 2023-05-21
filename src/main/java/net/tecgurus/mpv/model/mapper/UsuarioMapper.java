package net.tecgurus.mpv.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.model.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	UsuarioDto toDto(Usuario entity);
	Usuario toEntity(UsuarioDto dto);
	
	@Named(value = "resume")
	@Mapping(target = "password", ignore = true)
	UsuarioDto toUsuarioSummary(Usuario entity);
	
}
