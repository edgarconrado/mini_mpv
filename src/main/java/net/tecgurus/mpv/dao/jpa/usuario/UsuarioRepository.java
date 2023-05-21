package net.tecgurus.mpv.dao.jpa.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import net.tecgurus.mpv.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}
