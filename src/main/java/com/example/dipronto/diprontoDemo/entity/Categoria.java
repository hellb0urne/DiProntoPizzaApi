package com.example.dipronto.diprontoDemo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

}
