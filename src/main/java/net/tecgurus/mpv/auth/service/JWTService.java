package net.tecgurus.mpv.auth.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.model.entity.Usuario;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JWTService {

    private final String JWT_SECRET_KEY = "ZlbzdMcfqX3nHQZF8V46LG36eAvw9PeL";

    public String generateToken(UsuarioDto usuario) {

        Instant now = Instant.now();

        return Jwts
                .builder()
                .setSubject(usuario.getEmail())
                .setExpiration(Date.from(now.plus(60, ChronoUnit.MINUTES)))
                .claim("role", usuario.getPerfil())
                .claim("id",usuario.getIdUsuario())
                .signWith(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()))
                .compact()
        ;

    }

    public UsuarioDto getUserFromToken(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JWT_SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                ;

        String emial = claims.getSubject();
        Long id = claims.get("id", Long.class);
        String role = claims.get("role", String.class);

        return UsuarioDto.builder()
                .idUsuario(id)
                .email(emial)
                .perfil(Usuario.Perfil.valueOf(role))
                .build()
                ;


    }

}
