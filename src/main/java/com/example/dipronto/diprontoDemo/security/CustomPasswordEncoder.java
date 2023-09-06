package com.example.dipronto.diprontoDemo.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        // Aquí puedes implementar la lógica de codificación del password
        // Por simplicidad, en este ejemplo no realizaremos ninguna codificación
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Aquí puedes implementar la lógica para verificar si el password coincide con el password codificado
        // Por simplicidad, en este ejemplo compararemos los passwords sin codificar
        return rawPassword.toString().equals(encodedPassword);
    }
}
