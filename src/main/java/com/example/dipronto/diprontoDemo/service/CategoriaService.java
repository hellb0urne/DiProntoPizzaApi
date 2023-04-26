package com.example.dipronto.diprontoDemo.service;

import com.example.dipronto.diprontoDemo.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {


    Optional<Categoria> findByIdCat(Long id);
    Categoria addCat(Categoria categoria);
    Categoria findByNombre(String nombre);
     /*
    List<Categoria> findAllCat();
    void deleteCat(Long id);
    Categoria updateCat(Categoria categoria);


     */

}
