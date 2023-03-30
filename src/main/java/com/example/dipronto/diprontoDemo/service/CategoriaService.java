package com.example.dipronto.diprontoDemo.service;

import com.example.dipronto.diprontoDemo.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Categoria addCategoria(Categoria categoria);
    Optional<Categoria> findById(Long id);
    List<Categoria> findAll();
    void deleteCategoria(Long id);


}
