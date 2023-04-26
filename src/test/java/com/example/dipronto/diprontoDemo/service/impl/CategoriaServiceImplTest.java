package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.exception.CustomException;
import com.example.dipronto.diprontoDemo.repository.DaoCategoria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceImplTest {

    @Mock
    private DaoCategoria daoCategoria;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @Test
    void addCat() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Promociones Familiares");
        Categoria cat = categoriaService.findByNombre("Promociones Medianas");
        daoCategoria.save(ArgumentMatchers.any(Categoria.class));
        categoriaService.addCat(categoria);
        assertNull(cat);
    }

    @Test
    void findByIdCat() {
        long id = 1;
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Promociones Familiares");
        Mockito.when(daoCategoria.findById(id)).thenReturn(Optional.of(categoria));
        categoriaService.findByIdCat(id);
    }

    @Test
    void findByNombre() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Promociones Familiares");
        Mockito.when(daoCategoria.findByNombre(categoria.getNombre())).thenReturn(categoria);
        Categoria cat = categoriaService.findByNombre(categoria.getNombre());
        assertEquals(cat.getNombre(), categoria.getNombre());
    }

    @Test
    void deleteCat() {
    }

    @Test
    void updateCat() {
    }

    @Test
    void findAllCat() {
    }

}