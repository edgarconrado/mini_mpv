package net.tecgurus.mpv.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.tecgurus.mpv.model.entity.compra.Compra;

@Repository
public interface ICompraDao {
	void create(Compra compra);
	Compra getById(Long id);
	List<Compra> listAll();
}
