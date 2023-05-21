package net.tecgurus.mpv.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.tecgurus.mpv.model.entity.Cliente;

@Repository
public interface IClienteDao {
	List<Cliente> listAll();
}
