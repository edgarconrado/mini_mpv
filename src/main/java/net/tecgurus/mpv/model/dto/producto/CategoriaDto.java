package net.tecgurus.mpv.model.dto.producto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"idcategoria"})
public class CategoriaDto {
	@JsonProperty("idcategoria")
    private Long idCategoria;
	
	@NotNull(message = "the field nombre can't be null")
	@NotBlank(message = "the field nombre can't be an empty string")
    private String nombre;
    private String descripcion;
}
