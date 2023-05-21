package net.tecgurus.mpv.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter 
@JsonPropertyOrder({"idproducto"})
public class InventarioDto {
	
	@JsonProperty("idproducto")
	private Long idProducto;
	
	private String nombre;
	private Integer stock;
	
	@JsonProperty("ventastotales")
	private Integer ventasTotales;
	
	@JsonProperty("cantidadvendidos")
	private Integer cantidadVendidos;
}
