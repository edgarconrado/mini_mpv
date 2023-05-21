package net.tecgurus.mpv.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.tecgurus.mpv.model.entity.producto.Categoria;

@Repository
public interface ICategoriaDao {
	void create(Categoria categoria);
	List<Categoria> listAll();
}
