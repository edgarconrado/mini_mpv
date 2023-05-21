package net.tecgurus.mpv.model.entity;

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
@Table(name = "producto")
public class Inventario {
	@Id
	@Column(name = "idproducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "stock")
	private Integer stock;
	
	@Column(name = "ventas_totales")
	private Double ventasTotales;
	
	@Column(name = "cantidad_vendidos")
	private Integer cantidadVendidos;

}
