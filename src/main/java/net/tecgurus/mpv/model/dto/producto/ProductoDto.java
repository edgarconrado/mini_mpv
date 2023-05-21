package net.tecgurus.mpv.model.dto.producto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "idproducto" })
public class ProductoDto {
	@JsonProperty("idproducto")
	private Long idProducto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stock;
	private String sku;
	private String imagen;
	private CategoriaDto categoria;
}
