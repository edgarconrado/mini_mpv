package net.tecgurus.mpv.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.tecgurus.mpv.model.entity.Inventario;

@Repository
public interface IInventarioDao {
	List<Inventario> generateInventory();
}