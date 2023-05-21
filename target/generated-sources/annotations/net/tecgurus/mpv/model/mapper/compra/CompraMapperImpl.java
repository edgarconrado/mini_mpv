package net.tecgurus.mpv.model.mapper.compra;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.model.dto.compra.CompraProductoDto;
import net.tecgurus.mpv.model.dto.producto.CategoriaDto;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.model.entity.compra.Compra;
import net.tecgurus.mpv.model.entity.compra.CompraProducto;
import net.tecgurus.mpv.model.entity.producto.Categoria;
import net.tecgurus.mpv.model.entity.producto.Producto;
import net.tecgurus.mpv.model.mapper.ClienteMapper;
import net.tecgurus.mpv.model.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-20T13:47:43-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CompraMapperImpl implements CompraMapper {

    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public CompraDto toDto(Compra entity) {
        if ( entity == null ) {
            return null;
        }

        CompraDto compraDto = new CompraDto();

        compraDto.setUsuario( usuarioMapper.toUsuarioSummary( entity.getUsuario() ) );
        compraDto.setIdCompra( entity.getIdCompra() );
        compraDto.setTotal( entity.getTotal() );
        compraDto.setFecha( entity.getFecha() );
        compraDto.setCliente( clienteMapper.toDto( entity.getCliente() ) );
        compraDto.setProductos( compraProductoListToCompraProductoDtoList( entity.getProductos() ) );

        return compraDto;
    }

    @Override
    public Compra toEntity(CompraDto dto) {
        if ( dto == null ) {
            return null;
        }

        Compra compra = new Compra();

        compra.setIdCompra( dto.getIdCompra() );
        compra.setTotal( dto.getTotal() );
        compra.setFecha( dto.getFecha() );
        compra.setCliente( clienteMapper.toEntity( dto.getCliente() ) );
        compra.setUsuario( usuarioMapper.toEntity( dto.getUsuario() ) );
        compra.setProductos( compraProductoDtoListToCompraProductoList( dto.getProductos() ) );

        return compra;
    }

    protected CategoriaDto categoriaToCategoriaDto(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDto categoriaDto = new CategoriaDto();

        categoriaDto.setIdCategoria( categoria.getIdCategoria() );
        categoriaDto.setNombre( categoria.getNombre() );
        categoriaDto.setDescripcion( categoria.getDescripcion() );

        return categoriaDto;
    }

    protected ProductoDto productoToProductoDto(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDto productoDto = new ProductoDto();

        productoDto.setIdProducto( producto.getIdProducto() );
        productoDto.setNombre( producto.getNombre() );
        productoDto.setDescripcion( producto.getDescripcion() );
        productoDto.setPrecio( producto.getPrecio() );
        productoDto.setStock( producto.getStock() );
        productoDto.setSku( producto.getSku() );
        productoDto.setImagen( producto.getImagen() );
        productoDto.setCategoria( categoriaToCategoriaDto( producto.getCategoria() ) );

        return productoDto;
    }

    protected CompraProductoDto compraProductoToCompraProductoDto(CompraProducto compraProducto) {
        if ( compraProducto == null ) {
            return null;
        }

        CompraProductoDto compraProductoDto = new CompraProductoDto();

        compraProductoDto.setIdCompraProducto( compraProducto.getIdCompraProducto() );
        compraProductoDto.setCantidad( compraProducto.getCantidad() );
        compraProductoDto.setCosto( compraProducto.getCosto() );
        compraProductoDto.setProducto( productoToProductoDto( compraProducto.getProducto() ) );

        return compraProductoDto;
    }

    protected List<CompraProductoDto> compraProductoListToCompraProductoDtoList(List<CompraProducto> list) {
        if ( list == null ) {
            return null;
        }

        List<CompraProductoDto> list1 = new ArrayList<CompraProductoDto>( list.size() );
        for ( CompraProducto compraProducto : list ) {
            list1.add( compraProductoToCompraProductoDto( compraProducto ) );
        }

        return list1;
    }

    protected Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto) {
        if ( categoriaDto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( categoriaDto.getIdCategoria() );
        categoria.setNombre( categoriaDto.getNombre() );
        categoria.setDescripcion( categoriaDto.getDescripcion() );

        return categoria;
    }

    protected Producto productoDtoToProducto(ProductoDto productoDto) {
        if ( productoDto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setIdProducto( productoDto.getIdProducto() );
        producto.setNombre( productoDto.getNombre() );
        producto.setDescripcion( productoDto.getDescripcion() );
        producto.setPrecio( productoDto.getPrecio() );
        producto.setStock( productoDto.getStock() );
        producto.setSku( productoDto.getSku() );
        producto.setImagen( productoDto.getImagen() );
        producto.setCategoria( categoriaDtoToCategoria( productoDto.getCategoria() ) );

        return producto;
    }

    protected CompraProducto compraProductoDtoToCompraProducto(CompraProductoDto compraProductoDto) {
        if ( compraProductoDto == null ) {
            return null;
        }

        CompraProducto compraProducto = new CompraProducto();

        compraProducto.setIdCompraProducto( compraProductoDto.getIdCompraProducto() );
        compraProducto.setCantidad( compraProductoDto.getCantidad() );
        compraProducto.setCosto( compraProductoDto.getCosto() );
        compraProducto.setProducto( productoDtoToProducto( compraProductoDto.getProducto() ) );

        return compraProducto;
    }

    protected List<CompraProducto> compraProductoDtoListToCompraProductoList(List<CompraProductoDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CompraProducto> list1 = new ArrayList<CompraProducto>( list.size() );
        for ( CompraProductoDto compraProductoDto : list ) {
            list1.add( compraProductoDtoToCompraProducto( compraProductoDto ) );
        }

        return list1;
    }
}
