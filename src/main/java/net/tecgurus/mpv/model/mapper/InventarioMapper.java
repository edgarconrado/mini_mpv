package net.tecgurus.mpv.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import net.tecgurus.mpv.model.dto.InventarioDto;
import net.tecgurus.mpv.model.entity.Inventario;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventarioMapper {
	Inventario toEntity(InventarioDto dto);
	InventarioDto toDto(Inventario entity);
}
