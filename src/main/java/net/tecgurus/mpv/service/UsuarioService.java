package net.tecgurus.mpv.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IUsuarioDao;
import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.model.entity.Usuario;
import net.tecgurus.mpv.model.mapper.UsuarioMapper;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	
	private final IUsuarioDao usuarioDao;
	private final UsuarioMapper usuarioMapper;
	
	public void signup(UsuarioDto usuario) {
		//TODO: encrypt password
		Usuario entity = this.usuarioMapper.toEntity(usuario);
		this.usuarioDao.create(entity);
		usuario.setIdUsuario(entity.getIdUsuario());
	}
	
	public UsuarioDto getByEmail(String email) {
		Usuario entity = this.usuarioDao.getByEmail(email);
		return this.usuarioMapper.toDto(entity);
	}
}
