package com.example.dipronto.diprontoDemo.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol role;

    public enum Rol {
        ADMIN,
        USER
    }

}
