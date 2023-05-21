package net.tecgurus.mpv.model.dto.compra;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.tecgurus.mpv.model.dto.ClienteDto;
import net.tecgurus.mpv.model.dto.UsuarioDto;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "idcompra" })
public class CompraDto {
	@JsonProperty("idcompra")
    private Long idCompra;
    private Double total;
    private LocalDate fecha;
    
    @NotNull
    private ClienteDto cliente;
    
    @NotNull
    private UsuarioDto usuario;

    @NotNull
    @JsonProperty("compraproductos")
    private List<CompraProductoDto> productos;
}
