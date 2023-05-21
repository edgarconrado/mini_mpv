package net.tecgurus.mpv.dao.jpa.producto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.tecgurus.mpv.model.entity.producto.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	@Query(value = 
		"""
		SELECT p FROM Producto p 
		WHERE 
			(p.stock > 0) and 
			(
				 p.descripcion like concat('%', :text ,'%') or 
				 p.nombre like concat('%', :text ,'%') or 
				 p.sku = :text
			)
		"""
	)
	List<Producto> search(@Param("text") String text);
	
	List<Producto> findByStockGreaterThan(Integer stock);
	
	Page<Producto> findByStockGreaterThan(Integer stock, Pageable pageable);
}
