package net.tecgurus.mpv.dao.jpa.inventario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.tecgurus.mpv.model.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

	String queryNativa = """
			SELECT
				p.idproducto, p.nombre, p.stock,
				COUNT(cp.idproducto) as cantidad_vendidos,
				SUM(cp.costo) as ventas_totales
			FROM producto p
			JOIN compraproducto cp ON cp.idproducto = p.idproducto
			GROUP BY p.idproducto
			""";

	@Query(value = queryNativa, nativeQuery = true)
	List<Inventario> generarInventario();
}
