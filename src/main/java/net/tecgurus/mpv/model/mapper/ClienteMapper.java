package net.tecgurus.mpv.model.mapper;

import org.mapstruct.Mapper;

import net.tecgurus.mpv.model.dto.ClienteDto;
import net.tecgurus.mpv.model.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	ClienteDto toDto(Cliente entity);
	Cliente toEntity(ClienteDto dto);
}
