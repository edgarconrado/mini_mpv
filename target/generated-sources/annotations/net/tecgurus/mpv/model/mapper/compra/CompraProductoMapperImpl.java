package net.tecgurus.mpv.model.mapper.compra;

import javax.annotation.processing.Generated;
import net.tecgurus.mpv.model.dto.compra.CompraProductoDto;
import net.tecgurus.mpv.model.entity.compra.CompraProducto;
import net.tecgurus.mpv.model.mapper.producto.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-20T13:47:43-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CompraProductoMapperImpl implements CompraProductoMapper {

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public CompraProductoDto toDto(CompraProducto entity) {
        if ( entity == null ) {
            return null;
        }

        CompraProductoDto compraProductoDto = new CompraProductoDto();

        compraProductoDto.setIdCompraProducto( entity.getIdCompraProducto() );
        compraProductoDto.setCantidad( entity.getCantidad() );
        compraProductoDto.setCosto( entity.getCosto() );
        compraProductoDto.setProducto( productoMapper.toDto( entity.getProducto() ) );

        return compraProductoDto;
    }

    @Override
    public CompraProducto toEntity(CompraProductoDto dto) {
        if ( dto == null ) {
            return null;
        }

        CompraProducto compraProducto = new CompraProducto();

        compraProducto.setIdCompraProducto( dto.getIdCompraProducto() );
        compraProducto.setCantidad( dto.getCantidad() );
        compraProducto.setCosto( dto.getCosto() );
        compraProducto.setProducto( productoMapper.toEntity( dto.getProducto() ) );

        return compraProducto;
    }
}
