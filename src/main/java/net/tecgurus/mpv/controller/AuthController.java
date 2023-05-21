package net.tecgurus.mpv.controller;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.auth.model.AuthRequest;
import net.tecgurus.mpv.auth.model.AuthResponse;
import net.tecgurus.mpv.auth.service.JWTService;
import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UsuarioDto autehnticatedUser = this.usuarioService.getByEmail(request.getEmail());
        if (autehnticatedUser == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access Denied");
        }

        String token = this.jwtService.generateToken(autehnticatedUser);

        AuthResponse response = AuthResponse.builder().acessToken(token).build();

        return ResponseEntity.ok(response);
    }


    @GetMapping("/password/{password}")
    public ResponseEntity<String> login(@PathVariable String password) {
        String passwordencoded = this.passwordEncoder.encode(password);
        return  ResponseEntity.ok(passwordencoded);
    }
}
