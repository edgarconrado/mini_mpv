package net.tecgurus.mpv.dao;

import org.springframework.stereotype.Repository;

import net.tecgurus.mpv.model.entity.Usuario;

@Repository
public interface IUsuarioDao {
	void create(Usuario usuario);
	Usuario getByEmail(String email);
}
