package net.tecgurus.mpv.model.dto.compra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "idcompraproducto" })
public class CompraProductoDto {
	@JsonProperty("idcompraproducto")
	private Long idCompraProducto;
	private Integer cantidad;
	private Double costo = 0.0;
	private ProductoDto producto;
}
