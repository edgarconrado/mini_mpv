package net.tecgurus.mpv.auth.service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IUsuarioDao;
import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.model.entity.Usuario;
import net.tecgurus.mpv.model.mapper.UsuarioMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final IUsuarioDao usuarioDao;
    private final UsuarioMapper usuarioMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario entity = this.usuarioDao.getByEmail(email);
        UsuarioDto usuario  = this.usuarioMapper.toDto(entity);

        if (usuario == null) {
            throw new UsernameNotFoundException("Invalid email or password");
        }

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getPerfil().toString());
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        return new User(usuario.getEmail(), usuario.getPassword(), authorities);
    }
}
