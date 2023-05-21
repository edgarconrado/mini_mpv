package net.tecgurus.mpv.model.mapper.producto;

import javax.annotation.processing.Generated;
import net.tecgurus.mpv.model.dto.producto.CategoriaDto;
import net.tecgurus.mpv.model.entity.producto.Categoria;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-20T13:47:43-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDto toDto(Categoria entity) {
        if ( entity == null ) {
            return null;
        }

        CategoriaDto categoriaDto = new CategoriaDto();

        categoriaDto.setIdCategoria( entity.getIdCategoria() );
        categoriaDto.setNombre( entity.getNombre() );
        categoriaDto.setDescripcion( entity.getDescripcion() );

        return categoriaDto;
    }

    @Override
    public Categoria toEntity(CategoriaDto dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( dto.getIdCategoria() );
        categoria.setNombre( dto.getNombre() );
        categoria.setDescripcion( dto.getDescripcion() );

        return categoria;
    }
}
