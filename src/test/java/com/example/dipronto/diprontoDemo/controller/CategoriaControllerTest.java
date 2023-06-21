package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.dto.TestCategoria;
import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CategoriaControllerTest {

    @Mock
    private CategoriaService categoriaService;

    @InjectMocks
    private CategoriaController categoriaController;


    @Test
    void addCategoria() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Promociones Familiares");
        Mockito.when(categoriaService.addCat(categoria)).thenReturn(categoria);
        categoriaController.addCategoria(categoria);

    }

    @Test
    void findAllCat() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Promociones Familiares");
        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(categoria);
        Mockito.when(categoriaService.findAllCat()).thenReturn(categoriaList);
        categoriaController.findAllCat();
    }


    @Test
    void deleteCat() {
        long id = 1;
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Promociones Familiares");
        categoriaController.deleteCat(id);


    }


    @Test
    void findByIdCat() {
        long id = 1L;
        Optional<Categoria> miOptional = TestCategoria.miCategoriaOptional();
        Mockito.when(categoriaService.findByIdCat(id)).thenReturn(miOptional);
        categoriaController.findByIdCat(id);
    }

    @Test
    void updateCat() {
        long id = 1L;
        Categoria categoria = TestCategoria.miCategoria();
        Mockito.when(categoriaService.updateCat(categoria)).thenReturn(categoria);
        categoriaController.updateCat(categoria);
    }
}