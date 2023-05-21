package net.tecgurus.mpv.model.entity.producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@Column(name = "idproducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "stock")
	private Integer stock;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "imagen")
	private String imagen;
	
	@ManyToOne
	@JoinColumn( name = "idcategoria" )
	private Categoria categoria;
	
}
