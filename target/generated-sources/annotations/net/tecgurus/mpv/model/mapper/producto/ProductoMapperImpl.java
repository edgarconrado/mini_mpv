package net.tecgurus.mpv.model.mapper.producto;

import javax.annotation.processing.Generated;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.model.entity.producto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-20T13:47:43-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public ProductoDto toDto(Producto entity) {
        if ( entity == null ) {
            return null;
        }

        ProductoDto productoDto = new ProductoDto();

        productoDto.setIdProducto( entity.getIdProducto() );
        productoDto.setNombre( entity.getNombre() );
        productoDto.setDescripcion( entity.getDescripcion() );
        productoDto.setPrecio( entity.getPrecio() );
        productoDto.setStock( entity.getStock() );
        productoDto.setSku( entity.getSku() );
        productoDto.setImagen( entity.getImagen() );
        productoDto.setCategoria( categoriaMapper.toDto( entity.getCategoria() ) );

        return productoDto;
    }

    @Override
    public Producto toEntity(ProductoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setIdProducto( dto.getIdProducto() );
        producto.setNombre( dto.getNombre() );
        producto.setDescripcion( dto.getDescripcion() );
        producto.setPrecio( dto.getPrecio() );
        producto.setStock( dto.getStock() );
        producto.setSku( dto.getSku() );
        producto.setImagen( dto.getImagen() );
        producto.setCategoria( categoriaMapper.toEntity( dto.getCategoria() ) );

        return producto;
    }
}
