package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.dto.LoginForm;
import com.example.dipronto.diprontoDemo.entity.User;
import com.example.dipronto.diprontoDemo.repository.UserRepository;
import com.example.dipronto.diprontoDemo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(JwtTokenProvider jwtTokenProvider, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm) {
        try {
            String username = loginForm.getUsername();
            User user = userRepository.findByNombre(username);

            if (user != null && passwordEncoder.matches(loginForm.getPassword(), user.getPassword())) {
                return jwtTokenProvider.createToken(username, user.getRole().name());
            } else {
                throw new BadCredentialsException("Nombre de usuario o contraseña incorrectos");
            }
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Nombre de usuario o contraseña incorrectos");
        }
    }
}
