package com.example.dipronto.diprontoDemo.service;

import com.example.dipronto.diprontoDemo.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Categoria addCat(Categoria categoria);
    Optional<Categoria> findByIdCat(Long id);
    List<Categoria> findAllCat();
    void deleteCat(Long id);
    Categoria updateCat(Categoria categoria);
    Categoria findByNombre(String nombre);

}
