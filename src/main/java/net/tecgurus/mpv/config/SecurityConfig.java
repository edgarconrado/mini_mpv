package net.tecgurus.mpv.config;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.auth.filter.CustomAccessDeniedHandler;
import net.tecgurus.mpv.auth.filter.JWTAuthenticationFilter;
import net.tecgurus.mpv.auth.filter.UnauthorizedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JWTAuthenticationFilter authenticationFilter;
    private final UnauthorizedHandler unauthorizedHandler;
    private final CustomAccessDeniedHandler accessDeniedHandler;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(
                        managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS
                        )
                )
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(
                        handling -> handling
                                .accessDeniedHandler(this.accessDeniedHandler)
                                .authenticationEntryPoint(this.unauthorizedHandler)
                )
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/compra/**").hasRole("USER")
                                .requestMatchers("/inventario/**").hasRole("ADMIN")
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/**").authenticated()

                )
                .build()
                ;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build()
                ;

    }

}
