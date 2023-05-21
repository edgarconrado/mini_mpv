package net.tecgurus.mpv.dao.jpa.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.tecgurus.mpv.dao.IUsuarioDao;
import net.tecgurus.mpv.model.entity.Usuario;

@Repository
public class UsuarioDaoJPAImpl implements IUsuarioDao{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void create(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario getByEmail(String email) {
		return this.usuarioRepository.findByEmail(email);
	}

}
