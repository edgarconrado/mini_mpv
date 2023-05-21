package net.tecgurus.mpv.model.mapper;

import javax.annotation.processing.Generated;
import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.model.entity.Usuario;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-20T13:47:42-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDto toDto(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDto.UsuarioDtoBuilder usuarioDto = UsuarioDto.builder();

        usuarioDto.idUsuario( entity.getIdUsuario() );
        usuarioDto.email( entity.getEmail() );
        usuarioDto.password( entity.getPassword() );
        usuarioDto.nombre( entity.getNombre() );
        usuarioDto.activo( entity.getActivo() );
        usuarioDto.perfil( entity.getPerfil() );

        return usuarioDto.build();
    }

    @Override
    public Usuario toEntity(UsuarioDto dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setIdUsuario( dto.getIdUsuario() );
        usuario.setEmail( dto.getEmail() );
        usuario.setPassword( dto.getPassword() );
        usuario.setNombre( dto.getNombre() );
        usuario.setAPaterno( dto.getAPaterno() );
        usuario.setAMaterno( dto.getAMaterno() );
        usuario.setActivo( dto.getActivo() );
        usuario.setPerfil( dto.getPerfil() );

        return usuario;
    }

    @Override
    public UsuarioDto toUsuarioSummary(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDto.UsuarioDtoBuilder usuarioDto = UsuarioDto.builder();

        usuarioDto.idUsuario( entity.getIdUsuario() );
        usuarioDto.email( entity.getEmail() );
        usuarioDto.nombre( entity.getNombre() );
        usuarioDto.activo( entity.getActivo() );
        usuarioDto.perfil( entity.getPerfil() );

        return usuarioDto.build();
    }
}
