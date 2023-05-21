package net.tecgurus.mpv.auth.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.auth.service.JWTService;
import net.tecgurus.mpv.model.dto.UsuarioDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Verify token exist
        if (!this.hasAuthenticationBearer(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Get token from request
        String token = getAccessToken(request);

        // Validate Token and get user
        UsuarioDto usuario = this.jwtService.getUserFromToken(token);

        // Set Authetication Context
        this.setAuthenticationContext(usuario, request);
        filterChain.doFilter(request, response);

    }

    private boolean hasAuthenticationBearer(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        return  !ObjectUtils.isEmpty(header) && header.startsWith("Bearer");
    }

    private String getAccessToken(HttpServletRequest request) {
        return request.getHeader("Authorization").split(" ")[1].trim();
    }

    private void setAuthenticationContext(UsuarioDto usuario, HttpServletRequest request) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getPerfil().toString());
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(usuario, null, authorities);

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
