package net.tecgurus.mpv.model.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@Column(name = "idusuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apaterno")
	private String aPaterno;
	
	@Column(name = "amaterno")
	private String aMaterno;
	
	@Column(name = "activo")
	private Boolean activo;
	
	@Column(name = "perfil")
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	public enum Perfil {
		ROLE_ADMIN,
		ROLE_USER
	}
	
}
