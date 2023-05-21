package net.tecgurus.mpv.model.mapper;

import javax.annotation.processing.Generated;
import net.tecgurus.mpv.model.dto.InventarioDto;
import net.tecgurus.mpv.model.entity.Inventario;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-20T13:47:43-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class InventarioMapperImpl implements InventarioMapper {

    @Override
    public Inventario toEntity(InventarioDto dto) {
        if ( dto == null ) {
            return null;
        }

        Inventario inventario = new Inventario();

        inventario.setIdProducto( dto.getIdProducto() );
        inventario.setNombre( dto.getNombre() );
        inventario.setStock( dto.getStock() );
        if ( dto.getVentasTotales() != null ) {
            inventario.setVentasTotales( dto.getVentasTotales().doubleValue() );
        }
        inventario.setCantidadVendidos( dto.getCantidadVendidos() );

        return inventario;
    }

    @Override
    public InventarioDto toDto(Inventario entity) {
        if ( entity == null ) {
            return null;
        }

        InventarioDto inventarioDto = new InventarioDto();

        inventarioDto.setIdProducto( entity.getIdProducto() );
        inventarioDto.setNombre( entity.getNombre() );
        inventarioDto.setStock( entity.getStock() );
        if ( entity.getVentasTotales() != null ) {
            inventarioDto.setVentasTotales( entity.getVentasTotales().intValue() );
        }
        inventarioDto.setCantidadVendidos( entity.getCantidadVendidos() );

        return inventarioDto;
    }
}
