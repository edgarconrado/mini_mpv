package net.tecgurus.mpv.model.entity.producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@Column(name = "idcategoria")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
}
