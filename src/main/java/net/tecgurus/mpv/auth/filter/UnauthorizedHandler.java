package net.tecgurus.mpv.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.tecgurus.mpv.auth.model.AuthErrorResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class UnauthorizedHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        AuthErrorResponse error = AuthErrorResponse.builder()
                .title("Unauthorized")
                .status(401)
                .details(authException.getMessage())
                .build()
                ;

        OutputStream output = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(output, error);
        output.flush();
    }
}
