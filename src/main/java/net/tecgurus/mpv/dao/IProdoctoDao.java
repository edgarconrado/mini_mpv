package net.tecgurus.mpv.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.tecgurus.mpv.model.entity.producto.Producto;

@Repository
public interface IProdoctoDao {
	List<Producto> listAll();
	List<Producto> listAll(int page, int limit);
	List<Producto> search(String search);
	List<Producto> listIn(List<Long> ids);
	void updateAll(List<Producto> productos);
}
