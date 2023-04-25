package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
        assertNotNull(categoria);

    }

    /*

    @Test
    void findAllCat() {
        Categoria categoria =  new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Promociones Familiares");
        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(categoria);
        Mockito.when(categoriaService.findAllCat()).thenReturn(categoriaList);
        categoriaController.findAllCat();
        assertEquals(categoriaList.size(), 1);
    }

    @Test
    void deleteCat() {
    }

    @Test
    void updateCat() {
    }

    @Test
    void findByIdCat() {
    }

     */
}