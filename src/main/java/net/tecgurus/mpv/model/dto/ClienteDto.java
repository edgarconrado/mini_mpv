package net.tecgurus.mpv.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "idcliente" })
public class ClienteDto {
	@JsonProperty("idcliente")
    private Long idCliente;
    private String nombre;
    
    @JsonProperty("apaterno")
    private String aPaterno;
    
    @JsonProperty("amaterno")
    private String aMaterno;
    private String rfc;
}
