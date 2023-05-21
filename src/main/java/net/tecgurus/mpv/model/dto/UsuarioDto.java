package net.tecgurus.mpv.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.tecgurus.mpv.model.entity.Usuario.Perfil;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "idusuario" })
public class UsuarioDto {
	
	@JsonProperty("idusuario")
    private Long idUsuario;
	
	@Email( message = "The field email must be a valid email format")
	@NotNull( message = "The field email is required")
	@NotBlank( message = "The field email can not be an empty string")
    private String email;
	
	@NotNull( message = "The field password is required")
	@NotBlank( message = "The field password can not be an empty string")
    private String password;
	
    private String nombre;
    
    @JsonProperty("apaterno")
    private String aPaterno;
    
    @JsonProperty("amaterno")
    private String aMaterno;
    
    private Boolean activo;
    private Perfil perfil;
}
