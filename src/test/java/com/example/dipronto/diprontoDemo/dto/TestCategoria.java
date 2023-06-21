package com.example.dipronto.diprontoDemo.dto;

import com.example.dipronto.diprontoDemo.entity.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestCategoria {

    public static Categoria miCategoria() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Promociones Familiares");
        return categoria;
    }

    public static Optional<Categoria> miCategoriaOptional() {
        Optional<Categoria> miOptional = Optional.of(miCategoria());
        return miOptional;
    }

    public static List<Categoria> miCategoriaIterable() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Promociones Familiares");
        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(categoria);
        return categoriaList;
    }
}
