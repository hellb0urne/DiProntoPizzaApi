package com.example.dipronto.diprontoDemo.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Este método se invocará cuando un usuario no autenticado intente acceder a un recurso protegido.
        // Responder con un error 401 (Unauthorized) para indicar que se requiere autenticación.
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
}
